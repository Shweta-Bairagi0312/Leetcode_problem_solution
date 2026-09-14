import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            boolean hasOne = false;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                if (x == 1) {
                    hasOne = true;
                }
            }

            if (hasOne) {
                System.out.println("Bessie");
            } else {
                System.out.println("Elsie");
            }
        }

        sc.close();
    }
}
