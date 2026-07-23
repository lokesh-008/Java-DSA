/*
Problem:
LeetCode 19 - Remove Nth Node From End of List

Link:
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Approach:
Two Pointers (Fast & Slow)

- Move the fast pointer n steps ahead.
- If fast becomes null, remove the head node.
- Otherwise, move both pointers until fast reaches the last node.
- Slow will be just before the node to remove.
- Delete the node by updating the next pointer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.next = next; }
 * }
 */

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
