
import java.util.*;

public class Main {

    static int n;
    static int[] a;

    static boolean check(long mid) {

        ArrayList<Integer> bad = new ArrayList<>();

        // Find edges whose difference is greater than mid
        for (int i = 1; i < n; i++) {
            if (Math.abs((long) a[i] - a[i - 1]) > mid) {
                bad.add(i);
            }
        }

        // More than two bad edges cannot be fixed
        if (bad.size() > 2) {
            return false;
        }

        // No operation is required
        if (bad.size() == 0) {
            return true;
        }

        long half = mid / 2;

        // Case 1: Two bad edges
        if (bad.size() == 2) {

            int p = bad.get(0);
            int q = bad.get(1);

            // Segment is [p+1, q]
            if (p + 1 > q) {
                return false;
            }

            // Check internal differences
            for (int i = p + 1; i < q; i++) {
                if (Math.abs((long) a[i] - a[i - 1]) > half) {
                    return false;
                }
            }

            // Check left boundary
            long left = Math.abs((long) a[p - 1] - 2L * a[q - 1]);

            if (left > mid) {
                return false;
            }

            // Check right boundary
            if (q < n) {
                long right = Math.abs(2L * a[p] - a[q]);

                if (right > mid) {
                    return false;
                }
            }

            return true;
        }

        // Case 2: Exactly one bad edge
        int p = bad.get(0);

        // Try making it the left boundary
        long maxDiff = 0;

        for (int r = p + 1; r <= n; r++) {

            // Newly included internal edge
            if (r > p + 1) {
                maxDiff = Math.max(
                    maxDiff,
                    Math.abs((long) a[r - 1] - a[r - 2])
                );
            }

            if (maxDiff > half) {
                break;
            }

            // Left boundary
            long left = Math.abs(
                (long) a[p - 1] - 2L * a[r - 1]
            );

            // Right boundary
            long right = 0;

            if (r < n) {
                right = Math.abs(
                    2L * a[p] - a[r]
                );
            }

            if (left <= mid && right <= mid) {
                return true;
            }
        }

        // Try making it the right boundary
        maxDiff = 0;

        for (int l = p; l >= 1; l--) {

            // Newly included internal edge
            if (l < p) {
                maxDiff = Math.max(
                    maxDiff,
                    Math.abs((long) a[l - 1] - a[l])
                );
            }

            if (maxDiff > half) {
                break;
            }

            // Left boundary
            long left = 0;

            if (l > 1) {
                left = Math.abs(
                    (long) a[l - 2] - 2L * a[p - 1]
                );
            }

            // Right boundary
            long right = Math.abs(
                2L * a[l - 1] - a[p]
            );

            if (left <= mid && right <= mid) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            n = sc.nextInt();
            a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long low = 0;
            long high = 2000000;
            long ans = high;

            while (low <= high) {

                long mid = low + (high - low) / 2;

                if (check(mid)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
