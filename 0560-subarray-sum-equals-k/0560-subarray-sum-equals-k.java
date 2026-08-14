import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix sum

        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum += num;

            // if (sum - k) has been seen before, those are valid starting points
            if (prefixCount.containsKey(sum - k)) {
                result += prefixCount.get(sum - k);
            }

            // record current prefix sum
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}