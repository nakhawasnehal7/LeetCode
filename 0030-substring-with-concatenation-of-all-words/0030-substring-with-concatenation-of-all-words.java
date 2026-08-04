class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return result;

        int wordLen  = words[0].length();
        int numWords = words.length;
        int n        = s.length();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.merge(w, 1, Integer::sum);
        }

        // Try each starting offset (0 to wordLen-1)
        for (int offset = 0; offset < wordLen; offset++) {
            Map<String, Integer> window = new HashMap<>();
            int left  = offset;
            int count = 0; // valid words in window

            for (int right = offset;
                 right + wordLen <= n;
                 right += wordLen) {

                // Add right word to window
                String rightWord = s.substring(right, right + wordLen);

                if (wordCount.containsKey(rightWord)) {
                    window.merge(rightWord, 1, Integer::sum);
                    count++;

                    // Shrink window if duplicate exceeds count
                    while (window.get(rightWord) > wordCount.get(rightWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.merge(leftWord, -1, Integer::sum);
                        count--;
                        left += wordLen;
                    }

                    // Found valid window!
                    if (count == numWords) {
                        result.add(left);
                        // Slide left by one word
                        String leftWord = s.substring(left, left + wordLen);
                        window.merge(leftWord, -1, Integer::sum);
                        count--;
                        left += wordLen;
                    }

                } else {
                    // Invalid word → reset window
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}