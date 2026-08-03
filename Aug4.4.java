class Solution {
    int replaceBit(int n, int k) {
        int bitmask = ~(1 << k);
        return n & bitmask;
    }
}
