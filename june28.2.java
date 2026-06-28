class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);

        }

        int freq = -1;
        for(int  count:map.values()){
            if(freq == -1){
                freq = count;
            }
            if( freq != count){
                return false;
            }
        }
        return true;
        
    }
}
