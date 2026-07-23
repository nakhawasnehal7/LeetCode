class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];  // shoot at end of first balloon

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                // Balloon starts AFTER arrow → need new arrow
                arrows++;
                arrowPos = points[i][1];  // shoot at end of this balloon
            }
            // Balloon still in range of arrow → already burst!
        }

        return arrows;
    }
}