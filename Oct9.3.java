import java.util.*;

public class Main {
    static long[] hash;

    static int[] buildSPF(int max) {
        int[] spf = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {
                spf[i] = i;

                if ((long) i * i <= max) {
                    for (int j = i * i; j <= max; j += i) {
                        if (spf[j] == 0) {
                            spf[j] = i;
                        }
                    }
                }
            }
        }

        return spf;
    }

    static long signature(int x, int[] spf) {
        long result = 0;

        while (x > 1) {
            int p = spf[x];
            int count = 0;

            while (x % p == 0) {
                x /= p;
                count++;
            }

            if (count % 2 == 1) {
                result ^= hash[p];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int max = 1;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                max = Math.max(max, a[i]);
            }

            int[] spf = buildSPF(max);
            hash = new long[max + 1];

            Random random = new Random(123456789L);

            for (int i = 2; i <= max; i++) {
                hash[i] = random.nextLong();
            }

            long[] prefix = new long[n];
            long current = 0;

            for (int i = 0; i < n; i++) {
                current ^= signature(a[i], spf);
                prefix[i] = current;
            }

            Map<Long, Long> freq = new HashMap<>();

            for (long x : prefix) {
                freq.put(x, freq.getOrDefault(x, 0L) + 1);
            }

            long answer = 0;

            for (int x : a) {
                long sig = signature(x, spf);
                answer += freq.getOrDefault(sig, 0L);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
