import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();

            boolean ok = false;
            int cntTwo = 0;

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();

                if (x >= 3) ok = true;
                if (x >= 2) cntTwo++;
            }

            if (ok || cntTwo >= 2)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}
