class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if(q.size()<k){
            return q;
            
        }
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i<k; i++){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        int n= q.size()-k;
        for(int i = 0; i<n; i++){
            q.add(q.poll());
        }
        return q;
    }
}
