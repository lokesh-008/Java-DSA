/*
Problem:
LeetCode 234 - Palindrome Linked List

Link:
https://leetcode.com/problems/palindrome-linked-list/

Approach:
Deep Copy + Reverse

- Create a deep copy of the linked list.
- Reverse the copied list recursively.
- Compare the original list with the reversed copy.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode a = head.next;
        ListNode newHead = reverseList(a);
        a.next = head;
        head.next = null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;

        // create a deep copy
        ListNode newHead = new ListNode(head.val);
        ListNode t1 = head.next;
        ListNode t2 = newHead;
        while(t1 != null){
            ListNode temp = new ListNode(t1.val);
            t2.next = temp;
            t1 = t1.next;
            t2 = t2.next;
        }
        newHead = reverseList(newHead);
        t1 = head;
        t2 = newHead;
        while(t1!=null){
            if(t1.val != t2.val){
                return false;
            } else{
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return true;
    }
}
