class Solution {
    public int minSubArrayLen(int target, int[] nums) { 
        int minlen = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];

            while(sum>=target){
                if(i-j+1<minlen){
                    minlen = i-j+1;
                }
                sum -= nums[j];
                j++;
            }
        }
        return minlen == Integer.MAX_VALUE?0:minlen;


    }
}
