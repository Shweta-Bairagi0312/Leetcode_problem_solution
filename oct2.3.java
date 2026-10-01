class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>list =  new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,list,res);
        return res;
    }
    private void backtrack(int[]nums,int i, List<Integer>list,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[i]);
        backtrack(nums,i+1,list,res);
        list.remove(list.size()-1);

        while(i+1<nums.length && nums[i]==nums[i+1]){
           i++;
        }
        backtrack(nums,i+1,list,res);

    }
}
