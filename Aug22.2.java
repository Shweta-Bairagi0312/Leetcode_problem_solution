class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch :s.toCharArray()){
            if(ch=='('){
                count++;
                sb.append(ch);
            }
            else if(ch==')' ){
                if(count>0){
                    count--;
                sb.append(ch);
                }
            }
            else{
                sb.append(ch);
            }
        }

        StringBuilder sb1 = new StringBuilder();

        for(int i = sb.length()-1; i>=0; i--){
            char ch = sb.charAt(i);
            if(ch=='('&& count>0){
                count--;
               

            }
            else{
                sb1.append(ch);

            }
        }
        return sb1.reverse().toString();
        
    }
}
