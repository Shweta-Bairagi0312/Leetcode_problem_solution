class Solution {
    int missingNum(int arr[]) {
        // code here
        long n = arr.length+1;
        long sum  =0;
        for(int i = 0; i<n-1; i++){
            sum += arr[i];
            
        }
        long sum1 = n*(n+1)/2;
         long missing = sum1-sum;
         return (int)missing;
        
    }
}
