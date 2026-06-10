class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>list = new ArrayList<>();
        boolean[]seen = new boolean[101];
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n-1];
        for(int num: nums){
            seen[num] = true;
        }
        for(int i = min; i<= max; i++){
            if(!seen[i]){
                list.add(i);
            }
        }

       return list;


    }
}
