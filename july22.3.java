class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character>st = new Stack<Character>();
        int i = 0;
        if(k==n){
            return "0";
        }
        while(i<n){
        while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i) ){
            st.pop();
            k--;

        }
        st.push(num.charAt(i));
        i++;
    }

    while(k>0){
        st.pop();
        k--;
    }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        sb.append(st.pop());
        sb.reverse();
       
       while(sb.length()>1 && sb.charAt(0)=='0')
        sb.deleteCharAt(0);
        
       

        return sb.toString();


    }
}
