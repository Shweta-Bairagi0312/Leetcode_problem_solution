import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 998244353L;

    static long modPow(long a, long e) {
        long res = 1;
        a %= MOD;

        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long dim = n * m - (n - r + 1) * (m - c + 1);

            sb.append(modPow(2, dim)).append('\n');
        }

        System.out.print(sb);
    }
}
