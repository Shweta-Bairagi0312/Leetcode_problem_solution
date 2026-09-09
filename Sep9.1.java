class Solution {
    public int longestOnes(int[] nums, int k) {
       int left = 0;
       int right = 0;
       int maxlen = 0;
       int zerocount = 0;
       while(right<nums.length){
        if(nums[right]==0){
            zerocount++;
        }
        while(zerocount>k){
            if(nums[left]==0){
                zerocount--;
            }
            left++;
        }
        maxlen = Math.max(maxlen,right-left+1);
        right++;
       }
       return maxlen;
       
    }
}
