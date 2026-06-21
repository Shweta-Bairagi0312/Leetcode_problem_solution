class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] res  = s.split(" ");

        for(String word: res){
            StringBuilder rev = new StringBuilder(word).reverse();

        sb.append(rev);
        sb.append(" ");
        }

        
     sb.deleteCharAt(sb.length()-1);
     return sb.toString();


        
    }
}
