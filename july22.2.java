class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      Stack<Integer>st = new Stack<>();
      for( int ast:asteroids){
        if(ast>0){
            st.push(ast);
        }
        else{
            while(!st.isEmpty() && st.peek()>0 &&st.peek()<-ast){
                st.pop();
            }
            if(st.isEmpty()|| st.peek()<0){
                st.push(ast);
            }
            if(st.peek()==-ast){
                st.pop();
            }
        }
      }
      int[]res = new int[st.size()];
      for(int i = st.size()-1; i>=0; i--){
        res[i] = st.pop();
      }
      return res;
    }
}
