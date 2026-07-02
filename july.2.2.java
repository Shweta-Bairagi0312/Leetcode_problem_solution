class Solution {
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for(int i = 0; i<words.length; i++){
            for(int j = i+1; j<words.length; j++){
                if(words[i].equals(reverse(words[j]))){
                    count++;
                }
            }
        }
        return count;
    }
}
