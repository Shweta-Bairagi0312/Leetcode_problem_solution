import java.io.*;
import java.util.*;

public class Main {

    static boolean hasBalancedPrefixes(String s) {
        int[] count = new int[3];

        // p0 = 0
        count[0] = 1;

        int remainder = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {

                // i is 0-based.
                // Original position = i + 1.
                //
                // Odd original position -> -1 ≡ 2 mod 3
                // Even original position -> +1
                if (i % 2 == 0) {
                    remainder = (remainder + 2) % 3;
                } else {
                    remainder = (remainder + 1) % 3;
                }
            }

            count[remainder]++;
        }

        int max = Math.max(count[0],
                    Math.max(count[1], count[2]));

        int min = Math.min(count[0],
                    Math.min(count[1], count[2]));

        return max - min <= 1;
    }

    static String constructString(int n) {

        // Special cases
        if (n == 1) {
            return "1";
        }

        if (n == 2) {
            return "10";
        }

        // First 1 around n/3
        for (int first = n / 3; first <= n / 3 + 1; first++) {

            // Second 1 around 2n/3
            for (int second = 2 * n / 3;
                 second <= 2 * n / 3 + 1;
                 second++) {

                // Either put third 1 or don't
                for (int putLastOne = 0;
                     putLastOne <= 1;
                     putLastOne++) {

                    if (first >= second) {
                        continue;
                    }

                    if (putLastOne == 1 && second >= n) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < n; i++) {
                        sb.append('0');
                    }

                    // Positions are 1-based
                    sb.setCharAt(first - 1, '1');
                    sb.setCharAt(second - 1, '1');

                    if (putLastOne == 1) {
                        sb.setCharAt(n - 1, '1');
                    }

                    String s = sb.toString();

                    if (hasBalancedPrefixes(s)) {
                        return s;
                    }
                }
            }
        }

        return "";
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            output.append(constructString(n))
                  .append('\n');
        }

        System.out.print(output);
    }
}
