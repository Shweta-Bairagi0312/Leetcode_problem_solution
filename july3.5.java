class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer>map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;
        for(int num:map.values()){
            if(num%2==1){
                odd = Math.max(odd,num);
            }else{
                even = Math.min(even,num);
            }
            
        }
        return odd-even;
    }
}
