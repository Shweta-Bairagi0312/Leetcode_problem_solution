class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer>st;

    public MinStack() {
        st = new Stack<>();
        
    }
    
    public void push(int value) {
        if(value<=min){
            st.push(min);
            min = value;
        }
        st.push(value);
        
    }
    
    public void pop() {
        int val = st.pop();
        if(val==min){
            min = st.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}
