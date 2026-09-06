class Solution {
    static long pairAndSum(int arr[]) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[i] & arr[j];
            }
        }

        return sum;
    }
}
