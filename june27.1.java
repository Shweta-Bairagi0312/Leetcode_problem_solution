class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String str1 = s.substring(0,n/2);
        String str2 = s.substring(n/2);
        int count1 = 0;
        int count2 = 0;
        String vowels = "aeiouAEIOU";

        for(char c: str1.toCharArray()){
            if(vowels.indexOf(c)!=-1){
                count1++;
            }
        }

        for(char c: str2.toCharArray()){
            if(vowels.indexOf(c)!=-1){
                count2++;
            }
        }

        return count1==count2;
     
    }
}
