
import java.util.*;

public class Main {

    static final int STATES = 54;
    static final int NEG = -1000000000;

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static boolean addEdge(int[] parent, int[] degree, int u, int v) {

        if (degree[u] == 2 || degree[v] == 2) {
            return false;
        }

        int pu = find(parent, u);
        int pv = find(parent, v);

        // Adding an edge inside the same component creates a cycle
        if (pu == pv) {
            return false;
        }

        parent[pu] = pv;

        degree[u]++;
        degree[v]++;

        return true;
    }

    static int encode(int da, int db, int same, int ends) {
        return (((da * 3 + db) * 2 + same) * 3 + ends);
    }

    static int solve(int n, int[] a, int[] b) {

        int[] dp = new int[STATES];
        Arrays.fill(dp, NEG);

        // Initially, a1 and b1 are disconnected
        dp[encode(0, 0, 0, 0)] = 0;

        int[] parent = new int[4];
        int[] degree = new int[4];

        // Process columns from left to right
        for (int i = 0; i < n - 1; i++) {

            int[] ndp = new int[STATES];
            Arrays.fill(ndp, NEG);

            for (int state = 0; state < STATES; state++) {

                if (dp[state] == NEG) {
                    continue;
                }

                // Decode DP state
                int x = state;

                int ends = x % 3;
                x /= 3;

                int same = x % 2;
                x /= 2;

                int db = x % 3;
                int da = x / 3;

                // Try all 8 combinations of the 3 edges
                for (int mask = 0; mask < 8; mask++) {

                    for (int k = 0; k < 4; k++) {
                        parent[k] = k;
                        degree[k] = 0;
                    }

                    degree[0] = da;
                    degree[1] = db;

                    // Restore previous connectivity
                    if (same == 1) {
                        parent[0] = 1;
                    }

                    int cost = 0;
                    boolean valid = true;

                    // Edge 1: a[i] - b[i]
                    if ((mask & 1) != 0) {

                        if (!addEdge(parent, degree, 0, 1)) {
                            valid = false;
                        } else {
                            cost += (a[i] == b[i] ? 2 : 1);
                        }
                    }

                    // Edge 2: a[i] - b[i+1]
                    if (valid && (mask & 2) != 0) {

                        if (!addEdge(parent, degree, 0, 3)) {
                            valid = false;
                        } else {
                            cost += (a[i] == b[i + 1] ? 2 : 1);
                        }
                    }

                    // Edge 3: b[i] - a[i+1]
                    if (valid && (mask & 4) != 0) {

                        if (!addEdge(parent, degree, 1, 2)) {
                            valid = false;
                        } else {
                            cost += (b[i] == a[i + 1] ? 2 : 1);
                        }
                    }

                    if (!valid) {
                        continue;
                    }

                    // Finalize the old column
                    if (i == 0) {

                        // Starting vertex a[0] must have degree 1
                        if (degree[0] != 1) {
                            continue;
                        }

                    } else {

                        if (degree[0] < 1 || degree[1] < 1) {
                            continue;
                        }
                    }

                    if (degree[1] > 2 || degree[0] > 2) {
                        continue;
                    }

                    int newEnds = ends;

                    if (degree[0] == 1) newEnds++;
                    if (degree[1] == 1) newEnds++;

                    if (newEnds > 2) {
                        continue;
                    }

                    // Every old component must connect to
                    // at least one vertex in the new column
                    int r0 = find(parent, 0);
                    int r1 = find(parent, 1);

                    int r2 = find(parent, 2);
                    int r3 = find(parent, 3);

                    if (r0 != r2 && r0 != r3) {
                        continue;
                    }

                    if (r1 != r2 && r1 != r3) {
                        continue;
                    }

                    // Connectivity of the new frontier
                    int newSame = (r2 == r3) ? 1 : 0;

                    int newState = encode(
                        degree[2],
                        degree[3],
                        newSame,
                        newEnds
                    );

                    ndp[newState] = Math.max(
                        ndp[newState],
                        dp[state] + cost
                    );
                }
            }

            dp = ndp;
        }

        // Process the last column
        int answer = NEG;

        for (int state = 0; state < STATES; state++) {

            if (dp[state] == NEG) {
                continue;
            }

            int x = state;

            int ends = x % 3;
            x /= 3;

            int same = x % 2;
            x /= 2;

            int db = x % 3;
            int da = x / 3;

            for (int mask = 0; mask < 2; mask++) {

                parent[0] = 0;
                parent[1] = 1;

                degree[0] = da;
                degree[1] = db;

                if (same == 1) {
                    parent[0] = 1;
                }

                int cost = 0;

                // Optional vertical edge in the last column
                if (mask == 1) {

                    if (!addEdge(parent, degree, 0, 1)) {
                        continue;
                    }

                    cost = (a[n - 1] == b[n - 1]) ? 2 : 1;
                }

                // Both vertices must have degree 1 or 2
                if (degree[0] < 1 || degree[1] < 1) {
                    continue;
                }

                if (degree[0] > 2 || degree[1] > 2) {
                    continue;
                }

                // For n = 1, a[0] is also the starting vertex
                if (n == 1 && degree[0] != 1) {
                    continue;
                }

                int totalEnds = ends;

                if (degree[0] == 1) totalEnds++;
                if (degree[1] == 1) totalEnds++;

                // Exactly two endpoints
                if (totalEnds != 2) {
                    continue;
                }

                // All vertices must belong to one component
                if (find(parent, 0) != find(parent, 1)) {
                    continue;
                }

                answer = Math.max(answer, dp[state] + cost);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            System.out.println(solve(n, a, b));
        }

        sc.close();
    }
}
