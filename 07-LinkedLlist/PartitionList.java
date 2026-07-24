/*
Problem:
LeetCode 86 - Partition List

Link:
https://leetcode.com/problems/partition-list/

Approach:
Two Dummy Lists

- Create two separate linked lists:
    1. Nodes with values less than x.
    2. Nodes with values greater than or equal to x.
- Traverse the original list once and append each node to the appropriate list.
- Connect the two lists together.
- Terminate the second list with null to avoid cycles.

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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(-1);

        ListNode tempA = a;
        ListNode tempB = b;
        ListNode temp = head;

        while(temp != null) {
            if(temp.val < x) {
                tempA.next = temp;
                tempA = tempA.next;
            } else {
                tempB.next = temp;
                tempB = tempB.next;
            }
            temp = temp.next;
        }

        tempB.next = null;
        a = a.next;
        b = b.next;

        if(a == null) {
            return b;
        }
        tempA.next = b;
        return a;
    }
}
