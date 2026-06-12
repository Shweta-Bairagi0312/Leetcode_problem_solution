class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(int i = 0; i<list.size(); i++){
            for(int j = i+1; j<list.size(); j++){
                int x = list.get(i);
                int y = list.get(j);

                if(map.get(x)!= map.get(y)){
                    return new int[]{x,y};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
