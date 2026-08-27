class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[]res = new int[]{-1,-1};
        int left  =  binarySearch(nums, target,true);
        int right = binarySearch(nums, target,false);
        res[0] = left;
        res[1] = right;

        return res;
    }
    public int binarySearch(int[] nums, int target,boolean isSearchLeft){
        int low = 0;
        int high = nums.length-1;
        int idx = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]> target){
                high = mid-1;
            }else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                idx = mid;
                if(isSearchLeft){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return idx;
    }
}
