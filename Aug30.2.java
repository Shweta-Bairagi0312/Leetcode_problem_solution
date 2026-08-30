class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatInTime(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canEatInTime(int[] piles, int k, int h) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; 

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}
