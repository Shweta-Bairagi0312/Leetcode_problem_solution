class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m = nums1.length;
       int n = nums2.length;
       int[]res = new int[m+n];
       int k = 0;

       for(int i = 0;i<nums1.length; i++){
        res[k++] = nums1[i];
       }
       for(int i = 0;i<nums2.length; i++){
        res[k++] = nums2[i];
       }
       Arrays.sort(res);

       int len = res.length;

       if(len%2==1){
        return (double) res[len/2];
       }
       else{
        int mid1 = res[len/2-1];
        int mid2 = res[len/2];
        return ((double)mid1 + (double)mid2)/2.0;
       }



        
    }
}
