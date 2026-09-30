class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        genrateSubset(nums,0,new ArrayList<>(),res);
        return res;

    }
    public void genrateSubset(int[] nums, int indx, List<Integer>list,List<List<Integer>>res){
        if(indx==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[indx]);
        genrateSubset(nums,indx+1,list,res);
        list.remove(list.size()-1);

        genrateSubset(nums,indx+1,list,res);


    }
}
