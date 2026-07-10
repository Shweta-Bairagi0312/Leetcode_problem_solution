class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = arr[0];
        int sclargest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>largest){
                sclargest = largest;
                largest = arr[i];
            }
            else if(arr[i]>sclargest && arr[i]!= largest){
                sclargest = arr[i];
            }
        }
        return ((sclargest==Integer.MIN_VALUE)? -1:sclargest);
    }
}
