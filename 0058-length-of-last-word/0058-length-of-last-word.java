class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // remove trailing spaces
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') break; // hit a space → stop
            length++;
        }

        return length;
    }
}