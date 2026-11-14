
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            ArrayList<Integer> ans = new ArrayList<>();

            int k = 0;

            // First: one copy of every distinct height
            for (int i = 0; i < n; ) {
                int j = i;

                while (j < n && a[j] == a[i]) {
                    j++;
                }

                ans.add(a[i]);
                k++;

                if (j - i >= 2) {
                    k++;
                }

                i = j;
            }

            // Second: extra copies (beyond two)
            for (int i = 0; i < n; ) {
                int j = i;

                while (j < n && a[j] == a[i]) {
                    j++;
                }

                for (int x = 0; x < j - i - 2; x++) {
                    if (j - i > 2) {
                        ans.add(a[i]);
                    }
                }

                i = j;
            }

            // Third: second copies in decreasing order
            int i = n - 1;

            while (i >= 0) {
                int j = i;

                while (j >= 0 && a[j] == a[i]) {
                    j--;
                }

                if (i - j >= 2) {
                    ans.add(a[i]);
                }

                i = j;
            }

            System.out.println(k);

            for (int x : ans) {
                System.out.print(x + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
