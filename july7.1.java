class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer>st = new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                st.pop();
            }
            else if(op.equals("D")){
                st.push(st.peek()*2);
            }
            else if(op.equals("+")){
                int top1 = st.pop();
                int top2 = st.peek();
                st.push(top1);
                st.push(top1+top2);
            }
            else{
                st.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for(int num: st){
            total += num;
        }
        return total;
    }
}
