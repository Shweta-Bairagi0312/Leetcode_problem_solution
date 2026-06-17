class Solution {
    public String sortSentence(String s) {
        String[]str = s.split(" ");
        HashMap<Integer,String>map = new HashMap<>();
        for(String word: str){
            for(char ch:word.toCharArray()){
                if(Character.isDigit(ch)){
                    int pos = Character.getNumericValue(ch);
                    map.put(pos,word.replace(String.valueOf(ch),""));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<= str.length; i++){
            sb.append(map.get(i));
            if(i!= str.length) sb.append(" ");
        }
        return sb.toString();
        
    }
}
