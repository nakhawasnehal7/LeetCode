class LRUCache {

    class Node {
        int key;
        int val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int val) {
        if (!map.containsKey(val)) {
            return -1;
        }

        Node node = map.get(val);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, val);
        insert(newNode);
        map.put(key, newNode);
        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

}