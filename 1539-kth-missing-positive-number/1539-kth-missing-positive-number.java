class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;   // not enough missing numbers yet, search right
            } else {
                right = mid - 1;  // too many missing, search left
            }
        }

        // left = number of elements in arr that are <= the answer
        // answer = k missing numbers, shifted by however many array elements came before it
        return left + k;
    }
}