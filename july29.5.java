class Solution {
    int minSubsets(int arr[]) {
        // code here
        HashSet<Integer>set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        int count = 0;
        for(int nums : set){
            int el = nums;
            if(!set.contains(el-1)){
                while(set.contains(el)){
                    el++;
                }
                count++;
            }
        }
        return count;
    }
}
