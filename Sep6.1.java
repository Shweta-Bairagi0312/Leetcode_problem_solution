class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxlen = 0;
       int j = 0;
       Set<Character>charSet = new HashSet<>();
       for(int i = 0; i<s.length(); i++){
        
        while(charSet.contains(s.charAt(i))){
            charSet.remove(s.charAt(j));
            j++;
        }
        charSet.add(s.charAt(i));
        maxlen =  Math.max(maxlen, charSet.size());

       }
       return maxlen;
    }
}
