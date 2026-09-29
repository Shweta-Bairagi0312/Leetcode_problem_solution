class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<Integer>();
        HashSet<Integer> ans = new HashSet<Integer>();

        for(int num : nums1){
            st.add(num);
        }

        for(int num : nums2){
            if(st.contains(num)){
                ans.add(num);
            }
        }

        int index = 0;
        int arr[] = new int[ans.size()];

        for(int num : ans){
            arr[index++] = num;
        }

        return arr;
    }
}
