import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            boolean foundOne = false;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    foundOne = true;
                } else if (foundOne) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}
