/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Deque<Node> stack = new ArrayDeque<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                // save where to return after this child branch ends
                if (curr.next != null) {
                    stack.push(curr.next);
                }

                // splice the child in right after curr
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null; // no longer a separate branch
            }

            // if we've hit the end of this branch, pop back to where we left off
            if (curr.next == null && !stack.isEmpty()) {
                Node next = stack.pop();
                curr.next = next;
                next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}