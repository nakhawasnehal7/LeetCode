class Solution {
    public String reverseWords(String s) {

        // 1. split by spaces (regex handles multiple spaces)
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // 2. iterate from end to start
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}