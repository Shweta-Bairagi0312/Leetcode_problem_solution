class Solution {
    static boolean isEven(int n) {
        // code here
        int bitmask = 1;
        if((n & bitmask)==0){
            return true;
        }
        return false;
        
    }
}
