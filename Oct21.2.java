class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int currSum = arr[0];
        int minSum = arr[0];

        for(int i=1; i<n; i++){
            currSum = Math.min(arr[i], currSum + arr[i]);

            minSum = Math.min(currSum, minSum);
        }

        return minSum;
    }
}
