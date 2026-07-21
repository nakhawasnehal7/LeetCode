class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; // take first as reference

        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until it matches start of strs[i]
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // no common prefix
            }
        }

        return prefix;
    }
}