
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long m = sc.nextLong();
            long k = sc.nextLong();

            long[] l = new long[n];
            long[] r = new long[n];

            for (int i = 0; i < n; i++) {
                l[i] = sc.nextLong();
                r[i] = sc.nextLong();
            }

            if (k == 0) {
                System.out.println(Math.max(1, r[n - 1] + 1));
                continue;
            }

            long ans = -1;

            long infected = 0;
            int j = 0;

            for (int i = 0; i < n; i++) {

                long start = l[i];
                long end = start + m - 1;

                while (j < n && l[j] <= end) {
                    long left = Math.max(start, l[j]);
                    long right = Math.min(end, r[j]);

                    if (left <= right) {
                        infected += right - left + 1;
                    }

                    j++;
                }

                if (infected == k) {
                    ans = start;
                    break;
                }

                infected = 0;
                j = i + 1;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
