class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int temp = nums[i];
            LinkedList<Integer>digits = new LinkedList<>();
            while(temp>0){
                int rem = temp%10;
                digits.addFirst(rem);
                temp /= 10;
               
            }
            list.addAll(digits);
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            arr[i] = list.get(i);

        }
        return arr;
    }
}
