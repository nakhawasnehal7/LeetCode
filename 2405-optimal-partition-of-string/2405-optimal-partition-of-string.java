class Solution {
    public int partitionString(String s) {
        Set<Character> seen = new HashSet<>();
        int partitions = 1; // at least 1 partition

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                // Duplicate! start new partition
                partitions++;
                seen.clear();
            }
            seen.add(c);
        }

        return partitions;
    }
}