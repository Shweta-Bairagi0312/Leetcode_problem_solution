
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long l = sc.nextLong();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);

            // Special case
            if (l == 1) {
                long ans = 0;

                for (int i = 0; i < n - 1; i++) {
                    ans += a[i];
                }

                System.out.println(ans);
                continue;
            }

            // Already no dangerous pair
            if (a[n - 1] * a[n - 2] < l) {
                System.out.println(0);
                continue;
            }

            long x = a[n - 1];

            // Maximum possible value of y
            long y = 1;

            while ((y + 1) * (y + 1) < l) {
                y++;
            }

            int start = n - 2;
            long curr = 0;

            // Operations needed on largest element
            // to make its product with y < l
            long mx = Math.max(0L, x - (l - 1) / y);

            // Initially make first n-2 elements <= y
            while (start >= 0 && a[start] >= y) {
                curr += a[start] - y;
                start--;
            }

            long ans = curr + mx;

            // Try smaller values of y
            y--;

            for (; y >= 0; y--) {

                // Every already modified element
                // needs one additional decrement
                curr += (n - 2 - start);

                // Move pointer backwards
                while (start >= 0 && a[start] >= y) {
                    start--;
                }

                // Cost for largest element
                mx = 0;

                if (y > 0) {
                    mx = Math.max(0L, x - (l - 1) / y);
                }

                ans = Math.min(ans, curr + mx);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
