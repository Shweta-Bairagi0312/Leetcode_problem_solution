import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 676767677L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] a = new int[n];
            long sumNonOnes = 0;
            int lastNonOne = -1;

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());

                if (a[i] > 1) {
                    sumNonOnes += a[i];
                    lastNonOne = i;
                }
            }

            long ans;

            if (lastNonOne == -1) { // all ones
                ans = 1;
            } else {
                boolean trailingOne = false;

                for (int i = lastNonOne + 1; i < n; i++) {
                    if (a[i] == 1) {
                        trailingOne = true;
                        break;
                    }
                }

                ans = sumNonOnes + (trailingOne ? 1 : 0);
            }

            out.append(ans % MOD).append('\n');
        }

        System.out.print(out);
    }
}
