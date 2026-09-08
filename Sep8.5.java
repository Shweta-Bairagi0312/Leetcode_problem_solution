class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer,Integer>map = new HashMap<>();
        int maxlen = 0;
        while(right<fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            
            while(map.size()>=3){
             map.put(fruits[left], map.getOrDefault(fruits[left],0)-1);
             if(map.get(fruits[left])==0){
                map.remove(fruits[left]);
                left++;
             }
            right++;

            }
            int currlen = right-left+1;
            maxlen = Math.max(currlen,maxlen);

        }
        return maxlen;

        
    }
}
