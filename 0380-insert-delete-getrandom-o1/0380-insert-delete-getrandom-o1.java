class RandomizedSet {
    // val → index in list
    private Map<Integer, Integer> map;
    // stores all values
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map    = new HashMap<>();
        list   = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false; // already exists

        list.add(val);                    // add to end of list
        map.put(val, list.size() - 1);   // store its index
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // not found

        int idx     = map.get(val);          // index of val
        int lastVal = list.get(list.size() - 1); // last element

        // Swap val with last element
        list.set(idx, lastVal);
        map.put(lastVal, idx);

        // Remove last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}