class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int lo = 1;
        int hi = 0;
        for (int num : piles) {
            hi = Math.max(hi, num);
        }

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;
            if (canFinishBabana(piles, mid, h)) {
                hi = mid;

            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public boolean canFinishBabana(int[] piles, int k, int h) {
        long hoursNeeded = 0;
        for (int pile : piles) {

            hoursNeeded += (pile + k - 1) / k; // ceiling division
        }
        return hoursNeeded <= h;

    }

}