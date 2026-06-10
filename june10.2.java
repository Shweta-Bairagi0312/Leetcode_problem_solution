class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        int sum = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int i = 0; i<nums.length; i++){
            int freq = map.get(nums[i]);
            if(freq%k==0){
                sum += nums[i];
            }
        }
        return sum;
        
    }
}
