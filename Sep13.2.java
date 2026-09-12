public int findElement(int[]nums,int i,int key){
if(i==nums.length){
return -1;
}
if(nums[i]==key){
return i;
}
return findElement(nums,i+1,key);
}
