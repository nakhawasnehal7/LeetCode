class Solution {
    public int trap(int[] height) {
        int left  = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                // left side is limiting
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // update max
                } else {
                    water += leftMax - height[left]; // trap water
                }
                left++;
            } else {
                // right side is limiting
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // update max
                } else {
                    water += rightMax - height[right]; // trap water
                }
                right--;
            }
        }

        return water;
    }
}