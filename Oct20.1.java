class Solution {
    public int findMin(int n) {
        // code here
        int count = 0;
        int[]coins = {10,5,2,1};
        
        for(int i = 0; i<coins.length; i++){
            while(coins[i]<=n){
                n -= coins[i];
                count++;
                
            }
        }
        return count;
        
    }
}
