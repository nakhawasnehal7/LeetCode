class Solution {
    public int compress(char[] chars) {

        int index = 0; // write pointer
        int i = 0;     // read pointer

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            // Count occurrences
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            // Write character
            chars[index++] = current;

            // Write count if > 1
            if (count > 1) {
                String cnt = String.valueOf(count);

                for (char c : cnt.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}