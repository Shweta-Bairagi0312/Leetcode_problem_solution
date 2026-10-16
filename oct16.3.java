
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            int[] next2 = new int[n + 1];
            int[] next0 = new int[n + 1];
            int[] next5 = new int[n + 1];
            int[] next6 = new int[n + 1];

            next2[n] = next0[n] = next5[n] = next6[n] = n;

            for (int i = n - 1; i >= 0; i--) {
                next2[i] = s.charAt(i) == '2' ? i : next2[i + 1];
                next0[i] = s.charAt(i) == '0' ? i : next0[i + 1];
                next5[i] = s.charAt(i) == '5' ? i : next5[i + 1];
                next6[i] = s.charAt(i) == '6' ? i : next6[i + 1];
            }

            long[] diffA = new long[n + 2];
            long[] diffB = new long[n + 2];

            for (int l = 0; l < n; l++) {
                int p1 = next2[l];
                if (p1 == n) continue;

                int p2 = next0[p1 + 1];
                if (p2 == n) continue;

                int p3 = next2[p2 + 1];
                if (p3 == n) continue;

                int p5 = next5[p3 + 1];
                if (p5 == n) continue;

                int p6 = next6[p3 + 1];

                // Bad substrings end at p5 ... p6 - 1.
                // If no 6 exists, they end at n - 1.
                if (p6 != n && p6 < p5) continue;

                int a = p5;
                int b = (p6 == n) ? n - 1 : p6 - 1;

                if (a > b) continue;

                long count = b - a + 1L;

                // Indices [l, a]: constant contribution.
                diffA[l] += count;
                diffA[a + 1] -= count;

                // Indices [a + 1, b]: contribution = b - i + 1.
                if (a + 1 <= b) {
                    diffA[a + 1] += b + 1L;
                    diffA[b + 1] -= b + 1L;

                    diffB[a + 1] -= 1;
                    diffB[b + 1] += 1;
                }
            }

            long A = 0, B = 0;

            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < n; i++) {
                A += diffA[i];
                B += diffB[i];

                long total = (long) (i + 1) * (n - i);
                long bad = A + B * i;

                if (i > 0) ans.append(' ');
                ans.append(total - bad);
            }

            System.out.println(ans);
        }
    }
}
