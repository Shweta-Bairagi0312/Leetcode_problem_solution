class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[]pair = intervals[0];
        ArrayList<int[]>list = new ArrayList<>();
        for(int i = 1; i<intervals.length; i++){
            int[]curr = intervals[i];
            if(curr[0]<=pair[1]){
                pair[1] = Math.max(pair[1],curr[1]);
            }
            else{
                list.add(pair);
                pair = intervals[i];
            }
        }
        list.add(pair);
        return list.toArray(new int[list.size()][]);


    }
}
