import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            int m = n - 4;

            long[] love = new long[m];

            // Calculate love value of every triad
            for (int i = 0; i < m; i++) {
                love[i] = a[i] + a[i + 2] - a[i + 4];
            }

            Map<Long, Long> freq = new HashMap<>();

            long ans = 0;

            for (int i = 0; i < m; i++) {

                long value = love[i];

                // All previous triads with the same value
                long same = freq.getOrDefault(value, 0L);

                // Previous triads that overlap with i:
                // i-1, i-2, i-4
                long invalid = 0;

                if (i - 1 >= 0 && love[i - 1] == value) {
                    invalid++;
                }

                if (i - 2 >= 0 && love[i - 2] == value) {
                    invalid++;
                }

                if (i - 4 >= 0 && love[i - 4] == value) {
                    invalid++;
                }

                ans += same - invalid;

                freq.put(value, same + 1);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
