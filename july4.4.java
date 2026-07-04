class Solution {
    public String trimTrailingVowels(String s) {
        String vowel = "aeiou";
        int i;
        for( i = s.length()-1; i>=0; i--){
            if(vowel.indexOf(s.charAt(i))!=-1){
                continue;
            }
            else{
                break;
            }
        }
        return s.substring(0,i+1);
    }
}
