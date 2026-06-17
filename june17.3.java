import java.io.*;
import java.util.*;

public class Main {
    static long ceilDiv(long a, long b) {
        return (a + b - 1) / b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long n = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long z = Long.parseLong(st.nextToken());

            // Nikita doesn't use AI
            long noAI = ceilDiv(n, x + y);

            // Nikita uses AI
            long withAI;
            long maximAlone = ceilDiv(n, x);

            if (maximAlone <= z) {
                // Project finishes before AI setup completes
                withAI = maximAlone;
            } else {
                long remaining = n - x * z;
                withAI = z + ceilDiv(remaining, x + 10 * y);
            }

            System.out.println(Math.min(noAI, withAI));
        }
    }
}
