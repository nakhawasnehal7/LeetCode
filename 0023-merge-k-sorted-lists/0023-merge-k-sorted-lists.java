/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min heap ordered by node value
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add head of each list to heap
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr  = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll(); // smallest!
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                heap.offer(node.next); // add next from same list
            }
        }

        return dummy.next;
    }
}