
import java.util.*;

public class Main {

    static final int MOD = 998244353;
    static final int MAX = 5000;

    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];
    static long[] bell = new long[MAX + 1];

    static long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;

        return fact[n] * invFact[r] % MOD
                * invFact[n - r] % MOD;
    }

    static void precompute() {

        fact[0] = 1;

        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAX] = power(fact[MAX], MOD - 2);

        for (int i = MAX; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        // Bell numbers
        bell[0] = 1;

        for (int i = 1; i <= MAX; i++) {

            for (int j = 0; j < i; j++) {
                bell[i] = (bell[i] +
                        nCr(i - 1, j) * bell[j]) % MOD;
            }
        }
    }

    static void update(int[] best, int[] ways,
                       int z, int candidate, int count) {

        if (candidate > best[z]) {
            best[z] = candidate;
            ways[z] = count;
        }
        else if (candidate == best[z]) {
            ways[z] = (int)((ways[z] + (long)count) % MOD);
        }
    }

    static void solve(String s) {

        int n = s.length();

        int[] suffixZero = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixZero[i] = suffixZero[i + 1];

            if (s.charAt(i) == '0') {
                suffixZero[i]++;
            }
        }

        // Rolling DP: next 4 positions
        int[][] dp = new int[4][n + 1];
        int[][] ways = new int[4][n + 1];

        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Base case
        dp[n % 4][0] = 0;
        ways[n % 4][0] = 1;

        for (int i = n - 1; i >= 0; i--) {

            int cur = i % 4;

            Arrays.fill(dp[cur], -1);
            Arrays.fill(ways[cur], 0);

            int maxZero = suffixZero[i];

            for (int z = 0; z <= maxZero; z++) {

                // Choice 1: Leave current index uncovered
                int nextZ = z;

                if (s.charAt(i) == '0') {
                    nextZ--;
                }

                if (nextZ >= 0) {

                    int next = (i + 1) % 4;

                    if (dp[next][nextZ] != -1) {

                        update(dp[cur], ways[cur], z,
                                dp[next][nextZ],
                                ways[next][nextZ]);
                    }
                }

                // Choice 2: Select a mixed pair
                if (i + 1 < n &&
                    s.charAt(i) != s.charAt(i + 1)) {

                    int next = (i + 2) % 4;

                    if (dp[next][z] != -1) {

                        update(dp[cur], ways[cur], z,
                                dp[next][z] + 2,
                                ways[next][z]);
                    }
                }

                // Choice 3: Select a mixed triple
                if (i + 2 < n &&
                    s.charAt(i) == s.charAt(i + 2) &&
                    s.charAt(i) != s.charAt(i + 1)) {

                    int next = (i + 3) % 4;

                    if (dp[next][z] != -1) {

                        update(dp[cur], ways[cur], z,
                                dp[next][z] + 3,
                                ways[next][z]);
                    }
                }
            }
        }

        // Find maximum coverage
        int maxCovered = -1;
        int row = 0;

        for (int z = 0; z <= suffixZero[0]; z++) {
            maxCovered = Math.max(maxCovered, dp[row][z]);
        }

        // Count all optimal partitions
        long count = 0;

        for (int z = 0; z <= suffixZero[0]; z++) {

            if (dp[row][z] == maxCovered) {

                int ones = n - maxCovered - z;

                long contribution =
                        (long) ways[row][z] * bell[z] % MOD;

                contribution =
                        contribution * bell[ones] % MOD;

                count = (count + contribution) % MOD;
            }
        }

        System.out.println((n + maxCovered) + " " + count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        precompute();

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            String s = sc.next();

            solve(s);
        }

        sc.close();
    }
}
