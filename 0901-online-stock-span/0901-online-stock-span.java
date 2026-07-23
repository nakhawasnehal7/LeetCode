class StockSpanner {
    // Stack stores [price, span]
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1; // at least today

        // Absorb spans of all smaller/equal prices
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // accumulate their spans
        }

        stack.push(new int[]{price, span});
        return span;
    }
}