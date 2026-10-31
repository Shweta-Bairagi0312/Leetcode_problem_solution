class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        // code here
        int k = totalTime;
        int n = arr.length;

        int max = 0;
        int sum = 0;

        for(int i=0; i < n && i<k; i++){
            sum += arr[i];
        }

        max = Math.max(sum, max);

        if(k > n){
            return max;
        }

        int j = 0;
        for(int i=k; i<n; i++){
            sum = sum + arr[i] - arr[j];
            max = Math.max(max, sum);
            j++;
        }

        return max;
    }
}
