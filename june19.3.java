class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        Map<Character,Integer>map = new HashMap<>();
       

        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            map.put(ch1, map.getOrDefault(ch1,0)+1);
        }

        for(int i = 0; i<t.length(); i++){
            char ch2 = t.charAt(i);
            if(!map.containsKey(ch2)|| map.get(ch2)==0){
                return false;
            }
            map.put(ch2,map.getOrDefault(ch2,0)-1);
        }

        return true;

        
    }
}
