import java.util.*;

public class Main {

    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = Math.min(solve(s, 0), solve(s, 1));

            System.out.println(ans == INF ? -1 : ans);
        }
    }

    static int solve(String s, int firstDeleted) {
        int n = s.length();

        // dp[lastKept + 1][lastDeleted + 1]
        // 2 means "nothing yet"
        int[][] dp = new int[3][3];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[2][2] = 0;

        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - '0';

            int[][] next = new int[3][3];

            for (int[] row : next) {
                Arrays.fill(row, INF);
            }

            for (int lastKept = 0; lastKept < 3; lastKept++) {
                for (int lastDeleted = 0; lastDeleted < 3; lastDeleted++) {

                    if (dp[lastKept][lastDeleted] == INF) continue;

                    // Option 1: Keep current character
                    // Final string must remain alternating
                    if (lastKept == 2 || lastKept != cur) {
                        next[cur][lastDeleted] =
                                Math.min(next[cur][lastDeleted],
                                        dp[lastKept][lastDeleted]);
                    }

                    // Option 2: Delete current character
                    boolean canDelete;

                    if (lastDeleted == 2) {
                        // First deleted character must match chosen starting bit
                        canDelete = (cur == firstDeleted);
                    } else {
                        // Deleted characters must alternate
                        canDelete = (cur != lastDeleted);
                    }

                    if (canDelete) {
                        next[lastKept][cur] =
                                Math.min(next[lastKept][cur],
                                        dp[lastKept][lastDeleted] + 1);
                    }
                }
            }

            dp = next;
        }

        int ans = INF;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
