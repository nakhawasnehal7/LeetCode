class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {

            if (map.containsKey(n)) {
               // int v = map.get(n);
                return n;
            }

            map.put(n, 1);
        }

        return -1;

    }
}