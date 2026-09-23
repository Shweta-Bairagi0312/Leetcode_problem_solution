import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            long diff = Math.abs(a - b);

            long answer = Math.max(diff, c - diff);

            System.out.println(answer);
        }

        sc.close();
    }
}
