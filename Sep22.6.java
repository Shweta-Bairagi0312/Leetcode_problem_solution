class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(), nums,0);
        return res;
    }
    private void backtrack(List<List<Integer>>res, List<Integer>list,int[]nums, int idx){
        res.add(new ArrayList<>(list));
        for(int i = idx; i<nums.length; i++){
           list.add(nums[i]);
            backtrack(res,list, nums,idx+1);
            list.remove(list.size()-1);

        }
    }
}
