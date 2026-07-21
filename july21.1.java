class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st = new Stack<>();
        for(String ch: operations){
            if(ch.equals("C")){
                st.pop();
            }
            else if(ch.equals("D")){
                st.push(st.peek()*2);
            }
            else if(ch.equals("+")){
                int t1 = st.pop();
                int t2 = st.peek();
                st.push(t1);
                st.push(t1+t2);
            }
            else{
                st.push(Integer.parseInt(ch));
            }
            

           

            
        }
        int total = 0;
            for(int num: st){
                total += num;
            }
        return total;
    }
}
