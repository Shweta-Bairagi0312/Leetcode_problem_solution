class Solution {
    public int majorityElement(int[] nums) {
     int el = 0;
     int count = 0;
     for(int i = 0; i<nums.length; i++){
        if(count==0){
            el = nums[i];
            count++;
        }
        else if(nums[i]==el){
            count++;
        }
        else{
            count = count-1;
        }
    }
    int n = nums.length;
     int count1 = 0;
     for(int num: nums){
        if(num==el){
            count1++;
        }
     }
     if(count1>n/2){
        return el;
     }

     return -1;


    }    
}    
