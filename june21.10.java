import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                mn = Math.min(mn, x);
                mx = Math.max(mx, x);
            }

            System.out.println((mx - mn + 1) / 2);
        }

        sc.close();
    }
}
