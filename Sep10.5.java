class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int left = 0;
        int oddcount = 0;
        int res = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 != 0) {
                oddcount++;
            }

            while (oddcount > k) {
                if (nums[left] % 2 != 0) {
                    oddcount--;
                }
                left++;
            }

            res += right - left + 1;
        }

        return res;
    }
}
