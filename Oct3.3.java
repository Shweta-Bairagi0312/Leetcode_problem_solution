import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            long m = sc.nextLong();

            // Impossible
            if (k > m) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            // Divide m into k positive numbers
            long q = m / k;
            int r = (int)(m % k);

            long[] block = new long[k];

            for (int i = 0; i < k; i++) {
                block[i] = q;
            }

            // Add 1 to r elements
            for (int i = k - r; i < k; i++) {
                block[i]++;
            }

            // Repeat the block
            for (int i = 0; i < n; i++) {
                System.out.print(block[i % k] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
