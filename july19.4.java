class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<Character>();
        int maxdepth = 0;
        for( char ch : s.toCharArray()){
            if(ch=='('){
                st.push(ch);
                maxdepth = Math.max(maxdepth, st.size());
            }
            else if( ch == ')'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        return maxdepth;
    }
}
