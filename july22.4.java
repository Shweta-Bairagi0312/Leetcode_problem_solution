class Solution {
    public int minDeletions(int[] arr) {
        // code here
        if(arr==null || arr.length ==0){
            return 0;
        }
        
        java.util.List<Integer>list = new java.util.ArrayList<>();
        for(int num:arr){
            if(list.isEmpty() || num> list.get(list.size()-1)){
                list.add(num);
            }
            else{
                int left = 0;
                int right = list.size()-1;
                while(left<right){
                    int mid = left+(right-left)/2;
                     if(list.get(mid)<num){
                         left = mid+1;
                     }
                     else{
                         right = mid;
                     }
                }
                list.set(left, num);
            }
        }
         int lisLength = list.size();
        return arr.length - lisLength;
    }
}
