/*
Problem:
LeetCode 24 - Swap Nodes in Pairs

Link:
https://leetcode.com/problems/swap-nodes-in-pairs/

Approach:
Dummy Node + Pointer Manipulation

- Create a dummy node before the head.
- Use a 'prev' pointer to track the node before the current pair.
- Swap every adjacent pair by updating the next pointers.
- Move 'prev' to the end of the swapped pair and continue.

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }
        return dummy.next;
    }
}
