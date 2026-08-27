class Solution {

    int maxArea(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;

        int[][] bar = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                bar[i][j] = (mat[i][j] == 1) ? 1 : 0;

                if (i > 0 && bar[i][j] != 0) {
                    bar[i][j] += bar[i - 1][j];
                }
            }
        }

        int ans = 0;

        for (int[] a : bar) {
            ans = Math.max(ans, getMaxArea(a, c));
        }

        return ans;
    }

    int getMaxArea(int[] a, int n) {

        Arrays.sort(a);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, a[i] * (n - i));
        }

        return ans;
    }
}
