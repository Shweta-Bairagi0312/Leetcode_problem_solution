class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       List<List<Integer>>res = new ArrayList<>();
       List<Integer>list = new ArrayList<>();
       makeCombination(candidates,target,0,0,list,res);
       return res;
    }
    public void  makeCombination(int[] candidates, int target, int indx, int total,List<Integer>list,List<List<Integer>>res){
        if(total==target){
            res.add(new ArrayList<>(list));
            return ;
        }
        if(total>target || indx>=candidates.length){
            return ;
        }
        list.add(candidates[indx]);
        makeCombination(candidates,target,indx+1,total+candidates[indx],list,res);
        list.remove(list.size()-1);



        while(indx+1<candidates.length && candidates[indx]==candidates[indx+1]){
            indx++;
        }
        makeCombination(candidates,target,indx+1,total,list,res);
    }

}
