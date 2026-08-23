class Solution {
    public String minRemoveToMakeValid(String s) {
       int leftCount = 0;
       int rightCount = 0;

       Stack<Character>st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char currentchar = s.charAt(i);

        if(currentchar == '('){
            leftCount++;
           
        }
        if(currentchar == ')'){
            rightCount++;
           
        }
        if(rightCount> leftCount){
            rightCount--;
            continue;

        }else{
            st.push(currentchar);
        }

     }  
     StringBuilder sb = new StringBuilder();
     while(!st.isEmpty()){
        char currentchar = st.pop();
    
     if(leftCount>rightCount && currentchar == '('){
        leftCount--;
     }else{
        sb.append(currentchar);
     }
    }
    return sb.reverse().toString();
        
    }
}
