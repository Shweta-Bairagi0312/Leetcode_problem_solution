class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);

    }
    public int atMost(int[]nums, int goal){
        int left = 0;
        int res = 0;
        int sum = 0;
        for(int right = 0;right< nums.length; right++){
             sum += nums[right];
            while(sum > goal && left <= right){
                sum -= nums[left];
                left++;

            }
            res += right-left+1;
        }
        return res;
    }
}
