class Solution {
    public int findMin(int n) {
        // code here
        int coincount = 0;
        int[]coin = {10,5,2,1};
        
        for(int i = 0; i<coin.length; i++){
            while(coin[i]<=n){
                n -= coin[i];
                coincount++;
            }
        }
        return coincount;
        
    }
}
