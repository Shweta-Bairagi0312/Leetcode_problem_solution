public int FirstOccurance(int[]nums, int i, int key ){
if(i==nums.length){
return -1;
}
     int isFound = FirstOccurance(nums,i+1,key );
return isFound;
}
