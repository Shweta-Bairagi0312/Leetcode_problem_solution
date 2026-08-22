import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            String s = sc.next();

            int m = 2 * n;

            int red = 0;
            int blue = 0;

            for (int i = 0; i < m; i++) {

                // No potato at this position
                if (s.charAt(i) == '0') {
                    continue;
                }

                int pos = i;

                // Potato can move to next position
                if (s.charAt((i + 1) % m) == '0') {
                    pos = (i + 1) % m;
                }

                // 0-based even = person 1,3,5... = Red
                // 0-based odd  = person 2,4,6... = Blue
                if (pos % 2 == 0) {
                    red++;
                } else {
                    blue++;
                }
            }

            System.out.println(red + " " + blue);
        }

        sc.close();
    }
}
