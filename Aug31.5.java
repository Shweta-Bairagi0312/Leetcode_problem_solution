import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int farthestNode;
    static int maxDistance;

    static void dfs(int node, int parent, int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, distance + 1);
            }
        }
    }

    static int[] findFarthest(int start, int n) {
        farthestNode = start;
        maxDistance = 0;

        dfs(start, -1, 0);

        return new int[]{farthestNode, maxDistance};
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            // Step 1: Find farthest node from 1
            int[] first = findFarthest(1, n);

            int A = first[0];

            // Step 2: Find farthest node from A
            int[] second = findFarthest(A, n);

            int B = second[0];
            int diameter = second[1];

            System.out.println(A + " " + B + " " + diameter);
        }
    }
}
