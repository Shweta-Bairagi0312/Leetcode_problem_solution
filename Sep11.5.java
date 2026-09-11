import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int zeros = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 0) zeros++;
            }

            if (a[0] == 0 && a[n - 1] == 0)
                System.out.println(0);
            else if (zeros >= 2)
                System.out.println(1 + (a[0] == 1 && a[n - 1] == 1 ? 1 : 0));
            else
                System.out.println(-1);
        }
    }
}
