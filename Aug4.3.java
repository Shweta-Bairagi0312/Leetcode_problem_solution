class Solution {
    static int setKthBit(int n, int k) {
        // code here
        int bitmask = 1<<k;
        int res = n | bitmask;
        if(res !=0){
            return res;
        }
        return 0;

    }
}
