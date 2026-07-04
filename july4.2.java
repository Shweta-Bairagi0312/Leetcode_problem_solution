class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
       int count = 1;
       for(int i = 1; i<s.length(); i++){
        if(s.charAt(i)!= s.charAt(i-1)&& count==k){
            return true;
        }
        if(s.charAt(i)!= s.charAt(i-1)) count = 0;
        count++;
       } 
       return (count==k);
    }
}
