class Solution {
    public void reverseString(char[] s) {
      int i =  0;
      int n = s.length;
      for(int j = n-1; j>=n/2; j--){
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
        i++;
      }
    }
}
