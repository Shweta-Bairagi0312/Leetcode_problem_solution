class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int n = nums.length;
       int count1 = 0;
       int count2 = 0;
       int el1 = 0;
       int el2 = 0;
       for(int i = 0; i<n;i++){
        if(count1==0 && nums[i]!= el2){
            count1++;
            el1 = nums[i];
        }
        else if(count2==0 && nums[i]!= el1){
            count2++;
            el2 = nums[i];
        }
        else if(nums[i]==el1){
            count1++;
        }
        else if(nums[i]==el2){
            count2++;
        }
        else{
            count1--;
            count2--;
        }
       }
       List<Integer>l = new ArrayList<>();
       int res  = n/3;
       int count11 = 0;
       int count22 = 0;
       for(int i = 0; i<n;i++){
        if(el1==nums[i]){
            count11++;

        }
        else if(el2==nums[i]){
            count22++;
        }
       }
       if(count11>res){
        l.add(el1);
       }
       if(count22>res){
        l.add(el2);
       }
       return l;
    }
}
