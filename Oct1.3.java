class Solution {
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        int max = 0, tasks = 0;
        for(int num: duration) max = Math.max(max, num);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[n], time = new int[n];
        for(pair p: dependency) {
            map.putIfAbsent(p.x, new ArrayList<>());
            map.get(p.x).add(p.y);
            inDegree[p.y] ++ ;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i ++) {
            if(inDegree[i] == 0) {
                que.add(i);
                time[i] = duration[i];
            }
        }
        while(!que.isEmpty()) {
            int cur = que.poll();
            tasks ++ ;
            if(!map.containsKey(cur)) continue;
            List<Integer> l = map.get(cur);
            for(int next: l) {
                if(--inDegree[next] == 0) 
                    que.add(next);
                time[next] = Math.max(time[next], time[cur] + duration[next]);
                max = Math.max(max, time[next]);
            }
        }
        return tasks < n ? -1 : max;
    }
}
