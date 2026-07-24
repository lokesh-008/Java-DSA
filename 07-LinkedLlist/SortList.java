/*
Problem:
LeetCode 148 - Sort List

Link:
https://leetcode.com/problems/sort-list/

Approach:
Merge Sort on Linked List

- Find the middle of the linked list using slow and fast pointers.
- Split the list into two halves.
- Recursively sort both halves.
- Merge the two sorted linked lists.

Time Complexity: O(n log n)
Space Complexity: O(log n) (Recursion Stack)
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
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(a != null && b != null) {
            if(a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }

        if(a == null) {
            temp.next = b;
        } else {
            temp.next = a;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
}
