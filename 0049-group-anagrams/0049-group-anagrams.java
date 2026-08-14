class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Sort the word to get key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add word to its group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}