/*
Problem:
LeetCode 61 - Rotate List

Link:
https://leetcode.com/problems/rotate-list/

Approach:
Length Calculation + Two Pointers

- Find the length of the linked list.
- Reduce k using:
    k = k % length
- If k becomes 0, return the original list.
- Move the fast pointer k nodes ahead.
- Move both slow and fast pointers until fast reaches the last node.
- The node after slow becomes the new head.
- Break the list at slow and connect the old tail to the old head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        k %= len;
        if(head == null || head.next == null || k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i <= k; i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
