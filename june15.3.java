class Solution {
    public void reverseString(char[] s) {
        int j = 0;
        int n = s.length;
        for(int i = n-1; i>=n/2; i--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j++;

        }
    }
}
