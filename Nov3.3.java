
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            long sum = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }

            boolean internal = false;

            // Check whether any internal core has mass >= 2
            for (int i = 1; i < n - 1; i++) {
                if (a[i] >= 2) {
                    internal = true;
                    break;
                }
            }

            if (internal) {
                System.out.println(sum - 1);
            }
            else if (a[0] >= 2 || a[n - 1] >= 2) {
                System.out.println(sum - (n - 1));
            }
            else {
                System.out.println(-1);
            }
        }

        sc.close();
    }
}
