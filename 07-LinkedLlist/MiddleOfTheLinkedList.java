/*
Problem:
LeetCode 876 - Middle of the Linked List

Link:
https://leetcode.com/problems/middle-of-the-linked-list/

Approach:
Slow and Fast Pointer

- Initialize two pointers: slow and fast.
- Move slow by one step.
- Move fast by two steps.
- When fast reaches the end, slow will be at the middle node.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
