class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int[][]activities = new int[start.length][2];
        for(int i = 0; i<start.length; i++){
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        Arrays.sort(activities,(a,b)->Integer.compare(a[1],b[1]));
        int count = 1;
        int endtime = activities[0][1];
        for(int i = 1; i<activities.length; i++){
            int curr = activities[i][0];
            if(curr>endtime){
                count++;
                endtime = activities[i][1];
            }
        }
        return count;
        
    }
}
