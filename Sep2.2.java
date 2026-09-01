class Solution {
    public String reverseWords(String s) {
       String[]str = s.split(" ");
        StringBuilder sb = new StringBuilder();
       for(String word: str){
        StringBuilder sb1 = new StringBuilder(word).reverse();
        sb.append(sb1);
        sb.append(" ");

       }
       sb.deleteCharAt(sb.length()-1);
       return sb.toString();

        
    }
}
