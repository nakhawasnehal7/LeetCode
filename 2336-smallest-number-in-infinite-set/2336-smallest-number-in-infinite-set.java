class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> addedBack;
    private int current;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        addedBack = new HashSet<>();
        current = 1; // pointer to smallest number not yet popped
    }

    public int popSmallest() {
        // if heap has addedBack numbers smaller than current, pop from heap
        if (!minHeap.isEmpty() && minHeap.peek() < current) {
            int val = minHeap.poll();
            addedBack.remove(val);
            return val;
        }
        // otherwise return current and advance pointer
        return current++;
    }

    public void addBack(int num) {
        // only add back if it was already popped (less than current)
        // and not already in the heap
        if (num < current && !addedBack.contains(num)) {
            addedBack.add(num);
            minHeap.offer(num);
        }
    }
}
    


