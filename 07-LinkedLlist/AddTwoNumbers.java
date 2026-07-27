/*
Problem:
LeetCode 2 - Add Two Numbers

Link:
https://leetcode.com/problems/add-two-numbers/

Approach:
Dummy Node + Carry Simulation

- Traverse both linked lists simultaneously.
- Add corresponding digits along with the carry.
- Create a new node containing (sum % 10).
- Update the carry as (sum / 10).
- If a carry remains after traversal, add one final node.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if(l1 != null) val1 = l1.val;
            if(l2 != null) val2 = l2.val;
            int sum = val1 + val2 + carry;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) {
            temp.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
