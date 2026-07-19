class Solution {
    public String makeGood(String s) {
       Stack<Character>st = new Stack<>();
       st.push(s.charAt(0));
       for(int i = 1; i<s.length(); i++){
         char[]str = s.toCharArray();

         if(!st.isEmpty() &&(st.peek()-str[i]== 32 ||st.peek()-str[i]== -32)){
            st.pop();
         }
         else{
            st.push(str[i]);
         }
       }
       String res = "";
       while(!st.isEmpty()){
        res = st.pop()+res;
       }

       return res;


    }
}
