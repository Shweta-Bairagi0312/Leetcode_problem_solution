class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxavg = 0;
        int sum = 0 , n= nums.length;
        for(int i = 0; i<n-k; i++){
             sum += nums[i];
            int avg = sum/k;
            maxavg = Math.max(maxavg, avg);
        }
        return maxavg;
    }
}
