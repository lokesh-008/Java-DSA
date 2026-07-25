/*
Problem:
LeetCode 234 - Palindrome Linked List

Link:
https://leetcode.com/problems/palindrome-linked-list/

Approach:
Reverse Second Half

- Find the middle using slow and fast pointers.
- Reverse the second half of the list.
- Compare the first half with the reversed second half.
- If all nodes match, the list is a palindrome.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode j = reverse(slow);
        ListNode i = head;
        while(j!=null){
            if(i.val != j.val) return false;
            i = i.next;
            j = j.next;
        }
        return true;
    }
}
