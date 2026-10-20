class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int[][]activities = new int[start.length][2];
        for(int i = 0; i<start.length; i++){
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        Arrays.sort(activities,(a,b)->Integer.compare(a[1],b[1]));
        int activitycount = 1;
        int prev = activities[0][1];
        for(int i = 1; i<activities.length; i++){
            if(activities[i][0]>prev){
                activitycount++;
                prev = activities[i][1];
            }
        }
        return activitycount;
        
        
    }
}
