class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int pidx = 0;
        int nidx = 1;
        for(int i = 0; i<n; i++){
            if(nums[i]<0){
                res[nidx]= nums[i];
                 nidx += 2;
            }
            else{
                res[pidx] = nums[i];
                pidx += 2;

            }
        }
       return res;

    }
}
