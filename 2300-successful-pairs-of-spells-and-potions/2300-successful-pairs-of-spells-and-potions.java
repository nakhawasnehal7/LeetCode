import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];

            // Find minimum potion value needed
            // spell * potion >= success
            // potion >= success / spell  (ceiling division)
            long minPotion = (success + spell - 1) / spell; // ceiling division

            // Binary search for first potion >= minPotion
            int lo = 0, hi = m;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (potions[mid] >= minPotion) {
                    hi = mid;       // try to go left
                } else {
                    lo = mid + 1;   // go right
                }
            }

            // lo = first valid index, all potions from lo to m-1 are valid
            pairs[i] = m - lo;
        }

        return pairs;
    }
}