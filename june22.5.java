class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String ,Integer>map = new HashMap<>();
        String[] word1 = s1.split(" ");
        String[] word2 = s2.split(" ");
        for(String ch1 : word1){
            map.put(ch1,map.getOrDefault(ch1,0)+1);
        }

        for(String ch2 : word2){
            map.put(ch2,map.getOrDefault(ch2,0)+1);
        }
        List<String>list = new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key)==1){
                list.add(key);
            }
        }
        return list.toArray(new String[0]);
    }
}
