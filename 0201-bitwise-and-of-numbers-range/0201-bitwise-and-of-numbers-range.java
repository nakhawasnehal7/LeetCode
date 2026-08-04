class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Shift both right until they're equal
        while (left != right) {
            left  >>= 1;
            right >>= 1;
            shift++;
        }

        // Shift back to get common prefix
        return left << shift;
    }
}