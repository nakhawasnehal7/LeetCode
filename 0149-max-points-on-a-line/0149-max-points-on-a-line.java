class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int maxCount = 2;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Normalize slope using GCD
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;

                // Handle sign: keep dx positive
                if (dx < 0) { dx = -dx; dy = -dy; }
                if (dx == 0) dy = 1;  // vertical line
                if (dy == 0) dx = 1;  // horizontal line

                String key = dx + "," + dy;
                slopeCount.merge(key, 1, Integer::sum);

                maxCount = Math.max(maxCount,
                           slopeCount.get(key) + 1); // +1 for point i
            }
        }

        return maxCount;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}