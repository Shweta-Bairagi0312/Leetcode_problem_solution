class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();
        for(String ch : tokens){
            if(ch.equals("+")){
                st.push(st.pop()+st.pop());

            }
            else if(ch.equals("-")){
                int sec = st.pop();
                int first = st.pop();
                st.push(first-sec);
            }
            else if(ch.equals("*")){
                st.push(st.pop()*st.pop());
            }
             else if(ch.equals("/")){
                int sec = st.pop();
                int first = st.pop();
                st.push(first/sec);
            }
            else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.peek();
        
    }
}
