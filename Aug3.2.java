class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[]nums = new int[n+1];
        for(int i = 0; i<n; i++){
            nums[0] = first;
            nums[i+1] = encoded[i]^nums[i];
        }
        return nums;
        
    }
}
