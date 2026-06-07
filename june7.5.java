class Solution {
    public int minimumOperations(int[] nums) {
        int countop = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%3 != 0){
                countop++;

            }
        }
        return countop;
        
    }
}
