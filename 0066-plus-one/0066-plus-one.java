class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // No carry, just increment and done
                return digits;
            }
            digits[i] = 0;        // Current digit is 9 → becomes 0, carry over
        }

        // All digits were 9 (e.g. 999 → 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}