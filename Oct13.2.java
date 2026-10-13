
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x >= 0 && Math.abs(y) <= x) {
                System.out.println(x);
            } else {
                System.out.println(-1);
            }
        }

        sc.close();
    }
}
