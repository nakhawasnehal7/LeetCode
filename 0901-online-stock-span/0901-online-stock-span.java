class StockSpanner {
    // Stack stores [price, span]
    public Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int spam = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            spam += stack.pop()[1];
        }

        stack.push(new int[] { price, spam });
        return spam;

    }

}