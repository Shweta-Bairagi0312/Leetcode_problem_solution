class Solution {
    int countCoordinates(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;

        boolean[][] pVisited = new boolean[N][M];
        boolean[][] qVisited = new boolean[N][M];

        for (int j = 0; j < M; j++) {
            if (!pVisited[0][j])
                bfs(pVisited, mat, 0, j);

            if (!qVisited[N - 1][j])
                bfs(qVisited, mat, N - 1, j);
        }

        for (int i = 0; i < N; i++) {
            if (!pVisited[i][0])
                bfs(pVisited, mat, i, 0);

            if (!qVisited[i][M - 1])
                bfs(qVisited, mat, i, M - 1);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pVisited[i][j] && qVisited[i][j])
                    ans++;
            }
        }

        return ans;
    }

    void bfs(boolean[][] visited, int[][] mat, int i, int j) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int[] d : dir) {

                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x >= 0 && x < n && y >= 0 && y < m &&
                    !visited[x][y] &&
                    mat[x][y] >= mat[cur[0]][cur[1]]) {

                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
