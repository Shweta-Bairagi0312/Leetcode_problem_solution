
import java.util.*;

public class Main {

    static ArrayList<Integer>[] adj;
    static int[] parent;
    static int[] size;

    static void dfs(int node, int par) {
        size[node] = 1;

        for (int child : adj[node]) {
            if (child == par) continue;

            dfs(child, node);
            size[node] += size[child];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            adj = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj[u].add(v);
                adj[v].add(u);
            }

            parent = new int[n + 1];
            size = new int[n + 1];

            dfs(1, 0);

            int first = 0;
            int second = 0;

            for (int child : adj[1]) {
                int s = size[child];

                if (s > first) {
                    second = first;
                    first = s;
                } else if (s > second) {
                    second = s;
                }
            }

            int ans = n - 1 - Math.max(0, first - second - 1);

            System.out.println(ans);
        }
    }
}
