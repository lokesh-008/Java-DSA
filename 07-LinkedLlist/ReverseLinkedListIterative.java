/*
Problem:
LeetCode 206 - Reverse Linked List

Link:
https://leetcode.com/problems/reverse-linked-list/

Approach:
Iterative (Three Pointers)

- Maintain three pointers:
    1. prev
    2. curr
    3. next
- Reverse each link while traversing the list.
- At the end, prev becomes the new head.

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
