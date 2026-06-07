class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[]a1 = new int[n];
        int[]a2 = new int[n];
        int idx1 = 1;
        int idx2 = 1;
        a1[0] = nums[0];
        a2[0] = nums[1];
        for(int i = 2; i<nums.length; i++){
            if(a1[idx1-1]>a2[idx2-1]){
                a1[idx1++] = nums[i];
            }
            else{

                a2[idx2++] = nums[i];

            }
        }
        for(int i = 0; i<idx1; i++){
             if(a1[i]!=0){
                nums[i] = a1[i];
             }
        }
        for(int i=idx1,j=0;j<idx2;j++,i++){
            if(a2[j]!=0){
                nums[i] = a2[j];
            }
        }
        return nums;

    }
}
