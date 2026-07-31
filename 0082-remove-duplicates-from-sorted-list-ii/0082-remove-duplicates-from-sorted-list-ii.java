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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);  // Dummy node before head
        ListNode prev = dummy;                    // Tracks last confirmed unique node

        while (prev.next != null) {
            ListNode curr = prev.next;

            // Check if curr starts a duplicate group
            if (curr.next != null && curr.val == curr.next.val) {
                int dupVal = curr.val;

                // Skip ALL nodes with this duplicate value
                while (prev.next != null && prev.next.val == dupVal) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;  // Unique node — move prev forward
            }
        }

        return dummy.next;
    }
}