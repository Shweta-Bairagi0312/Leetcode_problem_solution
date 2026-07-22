import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];
            int[] b = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalOnes = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                totalOnes += a[i];
            }

            st = new StringTokenizer(br.readLine());

            int mismatch = 0;
            int onesMismatch = 0;

            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());

                if (a[i] != b[i]) {
                    mismatch++;
                    if (a[i] == 1) {
                        onesMismatch++;
                    }
                }
            }

            if (mismatch == 0) {
                ans.append(0).append("\n");
            } else if (totalOnes == 0) {
                ans.append(-1).append("\n");
            } else if ((onesMismatch & 1) == 1) {
                ans.append(1).append("\n");
            } else {
                ans.append(2).append("\n");
            }
        }

        System.out.print(ans);
    }
}
