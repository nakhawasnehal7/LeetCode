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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            // Step 1: Find kth node from groupPrev
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;  // Less than k nodes left — stop

            ListNode groupNext = kth.next;  // Node after the group

            // Step 2: Reverse k nodes
            ListNode prev = groupNext;  // Tail of reversed group points to groupNext
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: Reconnect with previous part
            ListNode tmp = groupPrev.next;  // Will become tail of reversed group
            groupPrev.next = kth;           // Connect prev part → new head of group
            groupPrev = tmp;                // Move groupPrev to tail of reversed group
        }

        return dummy.next;
    }

    // Returns the kth node from node, or null if fewer than k nodes exist
    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}