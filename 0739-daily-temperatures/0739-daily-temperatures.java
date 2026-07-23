class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop all days that found their warmer day!
            while (!stack.isEmpty() && 
                    temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;  // days waited
            }
            stack.push(i); // push current day index
        }

        // Remaining indices in stack → answer stays 0
        return answer;
    }
}