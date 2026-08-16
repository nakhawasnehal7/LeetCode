class LRUCache {

    class Node {
        int key;
        int val;
        Node next, prev;

        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map  = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        remove(n);
        insert(n);
        return n.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node n = new Node(key, val);
        insert(n);
        map.put(key, n);

        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

    }

    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

}