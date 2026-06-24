class Solution {
    public List<String> commonChars(String[] words) {
        int[]last = count(words[0]);

        for(int i = 1; i<words.length; i++){
            last = intersection(last,count(words[i]));
        }

        List<String>res = new ArrayList<>();
        for(int i = 0; i<26; i++){
            while(last[i]!=0){
                char ch = (char)('a'+i);
                String c = String.valueOf(ch);
                while(last[i]>0){
                    res.add(c);
                    last[i]--;
                }
            }

        }
        return res;
    }
    
    public static int[] count(String s){
        int []t = new int[26];
        char[]chr = s.toCharArray();
        for(char ch: chr){
            t[ch-'a']++;
        }
        return t;

    }

    public static int[] intersection(int[]a, int[]b){
        int[]t = new int[26];
        for(int i = 0; i<26; i++){
            t[i] = Math.min(a[i],b[i]);
        }
        return t;
    }
}
