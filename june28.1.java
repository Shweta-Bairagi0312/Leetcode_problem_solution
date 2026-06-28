class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getValue(firstWord);
        int second = getValue(secondWord);
        int target = getValue(targetWord);
        return target==first+second;
        
    }
    public int getValue(String s){
        int num = 0;
        for(int i = 0; i<s.length(); i++){
            int val = s.charAt(i)-'a';
            num = num*10+val;
        }
        return num;
        

    }
}
