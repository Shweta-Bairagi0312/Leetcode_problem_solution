class Solution {
    public String makeSmallestPalindrome(String s) {
        char[]str = s.toCharArray();
        int n = str.length;
        for(int i = 0; i<n/2; i++){
            int j = n-i-1;
            if(str[i]!=str[j]){
                str[i] = str[j] = (char)Math.min(str[i],str[j]);
            }
        }
        return new String(str);
    }
}
