import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 998244353L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            if (n == 1) {
                System.out.println(0);
                continue;
            }

            Arrays.sort(a);

            // suffix[i] = a[i] + a[i+1] + ... + a[n-1]
            long[] suffix = new long[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                suffix[i] = (suffix[i + 1] + a[i]) % MOD;
            }

            // factorials
            long[] fact = new long[n + 1];
            fact[0] = 1;

            for (int i = 1; i <= n; i++) {
                fact[i] = fact[i - 1] * i % MOD;
            }

            long ans = 0;

            for (int i = 0; i < n - 1; i++) {

                // sum of (a[j] - a[i]) for all j > i
                long count = n - 1L - i;

                long sumHigher = suffix[i + 1];

                long contributionSum =
                        (sumHigher - (count % MOD) * (a[i] % MOD)) % MOD;

                if (contributionSum < 0)
                    contributionSum += MOD;

                /*
                    Number of trees containing a fixed edge i -> j:
                    i! * (n-2-i)!
                */
                long ways = fact[i] * fact[n - 2 - i] % MOD;

                ans = (ans + ways * contributionSum) % MOD;
            }

            System.out.println(ans);
        }
    }
}
