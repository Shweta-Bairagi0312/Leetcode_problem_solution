import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // Block 1
            for (int i = 1; i <= n; i++) {
                out.append(i).append(' ');
            }

            // Block 2
            for (int i = 1; i <= n; i++) {
                out.append(i).append(' ');
            }

            // Block 3: cyclic shift
            for (int i = 2; i <= n; i++) {
                out.append(i).append(' ');
            }
            out.append(1).append(' ');

            // Block 4
            for (int i = 1; i <= n; i++) {
                out.append(i).append(' ');
            }

            out.append('\n');
        }

        System.out.print(out);
    }
}
