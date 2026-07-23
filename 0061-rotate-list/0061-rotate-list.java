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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
            return head;

        // Step 1: Find length and tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Handle k > length
        k = k % length;
        if (k == 0) return head; // no rotation needed

        // Step 3: Make circular
        tail.next = head;

        // Step 4: Find new tail (length-k steps from head)
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
