class StockSpanner {
    Stack<int[]>st;

    public StockSpanner() {
        this.st = new Stack<>();
    }
    
    public int next(int price) {
       int count = 1;
       while(!st.isEmpty()&& st.peek()[0]<= price){
         count += st.peek()[1];
         st.pop();


       }
       st.push(new int[]{price,count});
       return count;
        
    }
}
