
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] freq = new int[n + 1];

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                freq[x]++;
            }

            boolean aliceWins = false;

            for (int x = 0; x <= n; x++) {
                if (freq[x] < 2 * k) {
                    aliceWins = (freq[x] == 2 * k - 1);
                    break;
                }
            }

            System.out.println(aliceWins ? "YES" : "NO");
        }

        sc.close();
    }
}
