class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxlen = 0;
       int j = 0;
       Map<Character, Integer>map = new HashMap<>();
       for(int i = 0; i<s.length(); i++){
        char ch = s.charAt(i);
        map.put(ch, map.getOrDefault(ch,0)+1);

        while(map.get(ch)>1){
            char leftchar = s.charAt(j);
            map.put(leftchar,map.get(leftchar)-1);

            if (map.get(leftchar) == 0) {
                    map.remove(leftchar);
                }
            j++;

        }
        
        maxlen = Math.max(maxlen,map.size());
        
        
       

       }
       return maxlen;
    }
}
