/*
Problem:
LeetCode 328 - Odd Even Linked List

Link:
https://leetcode.com/problems/odd-even-linked-list/

Approach:
Odd-Even Pointer Rearrangement

- Maintain two pointers:
    1. odd -> points to odd-positioned nodes.
    2. even -> points to even-positioned nodes.
- Save the head of the even list.
- Rearrange pointers so that all odd nodes come first,
  followed by all even nodes.
- Connect the odd list with the saved even head.

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
