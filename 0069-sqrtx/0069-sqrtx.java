class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;  // 0→0, 1→1

        int left = 1, right = x / 2;  // sqrt(x) never exceeds x/2 for x≥2

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid overflow

            if ((long) mid * mid == x) return mid;       // Perfect square
            else if ((long) mid * mid < x) left = mid + 1;  // Too small
            else right = mid - 1;                            // Too big
        }

        return right;  // right = floor(sqrt(x))
    }
}