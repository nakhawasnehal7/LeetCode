class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true; // 1 is perfect square

        long lo = 2, hi = num / 2; // sqrt(num) <= num/2

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq  = mid * mid;

            if (sq == num) return true;       // found!
            else if (sq < num) lo = mid + 1;  // go right
            else               hi = mid - 1;  // go left
        }

        return false;
    }
}