class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();
        makeCombination(candidates,target,0,0,new ArrayList<>(),res);
        return res;



    }
    public void makeCombination(int[] candidates,int target,int indx, int total, List<Integer>comb, List<List<Integer>>res){
        if(total==target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(total>target || indx>=candidates.length){
            return;
        }
        comb.add(candidates[indx]);
        makeCombination(candidates,target,indx,total+candidates[indx],comb,res);
        comb.remove(comb.size()-1);
        makeCombination(candidates,target,indx+1,total,comb,res);




}
}
