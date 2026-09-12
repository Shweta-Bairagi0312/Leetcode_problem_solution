public boolean isSorted(int[]nums, int i){
if(i==nums.length-1){
return true;

}
if(nums[i]>nums[i+1]){
return false;
}
return isSorted(nums,i+1);
}
