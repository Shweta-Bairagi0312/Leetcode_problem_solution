
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            char[] arr = s.toCharArray();

            int left = 0;
            int right = n - 1;

            int ans = 0;

            while (left < right) {

                if (arr[left] == arr[right]) {
                    left++;
                    right--;
                }
                else if (arr[left] > arr[right]) {
                    ans += arr[left] - arr[right];
                    left++;
                    right--;
                }
                else {
                    ans += arr[right] - arr[left];
                    left++;
                    right--;
                }
            }

            System.out.println(ans);
        }
    }
}
