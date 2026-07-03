class Solution {
    public String findValidPair(String s) {
        Map<Character,Integer>map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = 0; i<s.length()-1;i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);

            if(a!=b &&map.get(a)==a-'0'&&map.get(b)==b-'0'){
                return ""+a+b;
            }
        }
        return "";
        
    }
}
