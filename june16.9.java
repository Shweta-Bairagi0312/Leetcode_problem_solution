import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String s = br.readLine();

            boolean ok = true;

            for (int r = 0; r < k; r++) {
                int parity = 0;

                for (int i = r; i < n; i += k) {
                    if (s.charAt(i) == '1') {
                        parity ^= 1;
                    }
                }

                if (parity == 1) {
                    ok = false;
                    break;
                }
            }

            ans.append(ok ? "YES" : "NO").append('\n');
        }

        System.out.print(ans);
    }
}
