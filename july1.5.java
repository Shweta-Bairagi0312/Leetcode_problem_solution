import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n];
            long[] b = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    ok = false;
                    break;
                }
            }

            ans.append(ok ? "YES" : "NO").append('\n');
        }

        System.out.print(ans);
    }
}
