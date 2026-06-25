class Solution {
    public String sortString(String s) {
        int[]freq = new int[26];
        int max = 0;
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
            if(freq[ch-'a']>max){
                max = freq[ch-'a'];
            }
        }
        StringBuilder sb = new StringBuilder();
        while(max-->0){
            for(int i = 0; i<26; i++){
                if(freq[i]>0){
                    char ch = (char)('a'+i);
                    sb.append(ch);
                    freq[i]--;
                }
            }
            for(int i = 25; i>=0; i--){
                if(freq[i]>0){
                    char ch = (char)('a'+i);
                    sb.append(ch);
                    freq[i]--;
                }
            }
        }
        return sb.toString();
    }
}
