/*
Problem:
LeetCode 143 - Reorder List

Link:
https://leetcode.com/problems/reorder-list/

Approach:
Find Middle + Reverse + Merge

- Find the middle of the linked list.
- Split the list into two halves.
- Reverse the second half.
- Merge the two halves alternately.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode leftMid = middleNode(head);
        ListNode head2 = leftMid.next;
        leftMid.next = null;
        head2 = reverse(head2);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head!=null && head2!=null){
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        if(head==null) temp.next = head2;
        if(head2==null) temp.next = head;
        head = dummy.next;
    }
}
