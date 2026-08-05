class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;   // mid is not greater than target, move right
            } else {
                right = mid - 1;  // mid is a candidate, keep looking left for a smaller one
            }
        }

        // 'left' now points to the smallest letter > target,
        // or has gone past the array (wrap around)
        return letters[left % letters.length];
    }
}