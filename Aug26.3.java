import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            // Calculate compressed length
            int compressedLength = 1;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    compressedLength++;
                }
            }

            boolean canReduceByTwo = false;

            // Check if deleting s[i] merges two same characters
            for (int i = 1; i < n - 1; i++) {
                if (s.charAt(i - 1) == s.charAt(i + 1)) {
                    canReduceByTwo = true;
                    break;
                }
            }

            if (canReduceByTwo) {
                System.out.println(compressedLength - 2);
            } else {
                System.out.println(compressedLength - 1);
            }
        }
    }
}
