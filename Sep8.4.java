class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        String vowels ="aeiou";
        for(int i = 0; i<=s.length()-k; i++){
            int count1 = 0;
            for(int j = i ; j<i+k; j++){
                char c = s.charAt(j);
                if(vowels.indexOf(c)!=-1){
                    count1++;
                }
            }
            count = Math.max(count , count1);
        } 
        return count; 
    }
}
