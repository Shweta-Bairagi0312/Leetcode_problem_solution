class Solution {
    public boolean isPalindrome(String s) {
       int n = s.length();
       s = s.toLowerCase();
       String ori = "";
       String rev = "";
       for(int i = 0; i<n; i++){
        if(Character.isLetterOrDigit(s.charAt(i))==true){
            ori = ori+s.charAt(i);
            rev = s.charAt(i)+rev;

        }
       

       }
        return ori.equals(rev);
    }
}
