import java.io.*;
import java.util.*;

public class Main {

    static final int MAXN = 305;

    // Matrix represented using boolean arrays.
    static boolean[][] mat;
    static boolean[][] inv;

    static int n;

    static int[] rowCnt;
    static int[] colCnt;

    static class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void computeInverse() {

        boolean[][] a = new boolean[n][2 * n];

        // [M | I]
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                a[i][j] = mat[i][j];
            }

            a[i][n + i] = true;
        }

        // Gauss-Jordan over F2
        for (int col = 0; col < n; col++) {

            int pivot = -1;

            for (int row = col; row < n; row++) {

                if (a[row][col]) {
                    pivot = row;
                    break;
                }
            }

            // Matrix is guaranteed to have rank n
            if (pivot == -1) {
                throw new RuntimeException("Matrix is not invertible");
            }

            // Swap
            if (pivot != col) {
                boolean[] temp = a[pivot];
                a[pivot] = a[col];
                a[col] = temp;
            }

            // Eliminate this column from every other row
            for (int row = 0; row < n; row++) {

                if (row != col && a[row][col]) {

                    for (int j = col; j < 2 * n; j++) {
                        a[row][j] ^= a[col][j];
                    }
                }
            }
        }

        inv = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = a[i][n + j];
            }
        }
    }

    static void erase(int x, int y) {

        if (!mat[x][y]) return;

        mat[x][y] = false;

        rowCnt[x]--;
        colCnt[y]--;
    }

    static void updateInverseAfterErase(int x, int y) {

        /*
         * We deleted M[x][y].
         *
         * Over F2, the inverse can be updated using:
         *
         * inv[row][x] ?= inv[row][x] + inv[y][x] ...
         *
         * For this construction we update rows of the inverse
         * corresponding to columns which are still active.
         */

        boolean[] oldRow = inv[y].clone();

        for (int j = 0; j < n; j++) {

            if (colCnt[j] > 0 && inv[j][x]) {

                for (int k = 0; k < n; k++) {
                    inv[j][k] ^= oldRow[k];
                }
            }
        }
    }

    static Cell findCenter(int best) {

        if (best < n) {

            // best is a row
            int x = best;

            for (int y = 0; y < n; y++) {

                if (mat[x][y] && inv[y][x]) {
                    return new Cell(x, y);
                }
            }

        } else {

            // best is a column
            int y = best - n;

            for (int x = 0; x < n; x++) {

                if (mat[x][y] && inv[y][x]) {
                    return new Cell(x, y);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {

            n = fs.nextInt();
            int m = fs.nextInt();

            mat = new boolean[n][n];

            for (int i = 0; i < m; i++) {

                int x = fs.nextInt() - 1;
                int y = fs.nextInt() - 1;

                mat[x][y] = true;
            }

            rowCnt = new int[n];
            colCnt = new int[n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (mat[i][j]) {
                        rowCnt[i]++;
                        colCnt[j]++;
                    }
                }
            }

            /*
             * Initially M has rank n,
             * so M is invertible.
             */
            computeInverse();

            ArrayDeque<Cell> mustQ = new ArrayDeque<>();
            ArrayDeque<Cell> freeQ = new ArrayDeque<>();

            ArrayList<Cell> centers = new ArrayList<>();

            ArrayList<ArrayList<Cell>> answer = new ArrayList<>();

            while (true) {

                /*
                 * Collect cells until we have n cells
                 * for the next operation.
                 */
                while (mustQ.size() + freeQ.size() < n) {

                    int best = 0;

                    /*
                     * Find row/column with maximum number
                     * of remaining 1s.
                     */
                    for (int i = 0; i < n; i++) {

                        if (rowCnt[i] >= rowCnt[best]) {
                            best = i;
                        }
                    }

                    for (int j = 0; j < n; j++) {

                        if (colCnt[j] >= rowCnt[best]) {
                            best = n + j;
                        }
                    }

                    if (rowCnt[best] == 0 && best < n) {
                        break;
                    }

                    if (best >= n && colCnt[best - n] == 0) {
                        break;
                    }

                    Cell center = findCenter(best);

                    if (center == null) {
                        throw new RuntimeException(
                                "Center not found"
                        );
                    }

                    int x = center.x;
                    int y = center.y;

                    centers.add(center);

                    ArrayList<Cell> must =
                            new ArrayList<>();

                    ArrayList<Cell> free =
                            new ArrayList<>();

                    /*
                     * Remove every other 1
                     * from row x.
                     */
                    for (int j = 0; j < n; j++) {

                        if (j != y && mat[x][j]) {

                            must.add(new Cell(x, j));

                            erase(x, j);

                            updateInverseAfterErase(x, j);
                        }
                    }

                    /*
                     * Remove every other 1
                     * from column y.
                     */
                    for (int i = 0; i < n; i++) {

                        if (i != x && mat[i][y]) {

                            free.add(new Cell(i, y));

                            erase(i, y);

                            updateInverseAfterErase(i, y);
                        }
                    }

                    /*
                     * Remove center from the working matrix.
                     *
                     * It is stored separately in centers.
                     */
                    erase(x, y);

                    /*
                     * If the chosen object was a column,
                     * interchange the roles.
                     */
                    if (best >= n) {

                        ArrayList<Cell> temp = must;
                        must = free;
                        free = temp;
                    }

                    for (Cell c : must) {
                        mustQ.add(c);
                    }

                    for (Cell c : free) {
                        freeQ.add(c);
                    }
                }

                /*
                 * Construct one move.
                 */
                ArrayList<Cell> move =
                        new ArrayList<>();

                while (move.size() < n &&
                        !mustQ.isEmpty()) {

                    move.add(mustQ.poll());
                }

                while (move.size() < n &&
                        !freeQ.isEmpty()) {

                    move.add(freeQ.poll());
                }

                while (move.size() < n &&
                        !centers.isEmpty()) {

                    move.add(
                            centers.remove(
                                    centers.size() - 1
                            )
                    );
                }

                answer.add(move);

                /*
                 * No centers means everything has
                 * been removed.
                 */
                if (centers.isEmpty()) {
                    break;
                }
            }

            out.append(answer.size()).append('\n');

            for (ArrayList<Cell> move : answer) {

                out.append(move.size()).append('\n');

                for (Cell c : move) {

                    out.append(c.x + 1)
                       .append(' ')
                       .append(c.y + 1)
                       .append('\n');
                }
            }
        }

        System.out.print(out);
    }

    // Fast input
    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {

            if (ptr >= len) {

                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int res = 0;

            while (c > ' ') {

                res = res * 10 + (c - '0');
                c = read();
            }

            return res * sign;
        }
    }
}
