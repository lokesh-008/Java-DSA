/*
Problem:
LeetCode 206 - Reverse Linked List

Link:
https://leetcode.com/problems/reverse-linked-list/

Approach:
Recursion

- Recursively reverse the remaining list.
- Attach the current node to the end.
- Break the original forward link.
- Return the new head.

Time Complexity: O(n)
Space Complexity: O(n) (Recursion Stack)
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        ListNode newHead = reverseList(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
