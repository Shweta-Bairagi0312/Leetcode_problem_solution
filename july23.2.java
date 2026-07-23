class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Base cases for small arrays where a full triplet range cannot be established
        if (n < 3) {
            return n;
        }
        
        // Find the smallest power of 2 greater than n
        int nextPowerOfTwo = 1;
        while (nextPowerOfTwo <= n) {
            nextPowerOfTwo <<= 1;
        }
        
        return nextPowerOfTwo;
    }
}
