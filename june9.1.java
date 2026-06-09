class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for( int i = 0; i<nums.length; i++){
            boolean isGood = true;
            if(i-k>=0){
                if(nums[i]<=nums[i-k]){
                    isGood = false;
                }

            }

            if(i+k<n){
                if(nums[i]<=nums[i+k]){
                    isGood = false;
                }
            }
            if(isGood){
                sum += nums[i];
            }
        }
        return sum;
    }
}
