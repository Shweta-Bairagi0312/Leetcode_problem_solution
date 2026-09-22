import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            // dp[x] = minimum operations needed
            // to make every resulting number <= k
            int[] dp = new int[n + 1];

            for (int x = k + 1; x <= n; x++) {

                int best = Integer.MAX_VALUE;

                // Try every prime divisor p of x
                for (int p = 2; p * p <= x; p++) {
                    if (x % p == 0) {
                        best = Math.min(best, 1 + p * dp[x / p]);

                        // x/p may also be a prime divisor
                        int q = x / p;
                        if (q != p) {
                            best = Math.min(best, 1 + q * dp[x / q]);
                        }
                    }
                }

                // If x itself is prime
                if (best == Integer.MAX_VALUE) {
                    best = 1 + x * dp[1];
                }

                dp[x] = best;
            }

            long ans = 0;

            for (int x : a) {
                ans += dp[x];
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int res = 0;
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return res * sign;
        }
    }
}
