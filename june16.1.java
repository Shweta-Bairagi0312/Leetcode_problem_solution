class Solution {
    public int balancedStringSplit(String s) {
      int count = 0;
      int count1 = 0;
      for(int i = 0; i<s.length(); i++){
        if(s.charAt(i)=='R'){
            count1++;
        }
        else{
            count1--;
        }
        if(count1==0){
        count++;
      }
      }  
      
      return count++;
    }
}
