/*
Problem:
LeetCode 92 - Reverse Linked List II

Link:
https://leetcode.com/problems/reverse-linked-list-ii/

Approach:
Split + Reverse + Reconnect

- Find four important nodes:
    a -> node before left
    b -> left node
    c -> right node
    d -> node after right
- Disconnect the sublist.
- Reverse the sublist.
- Reconnect the three parts.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        ListNode a = null, b = null, c = null, d = null;
        int pos = 1;
        ListNode temp = head;
        while(temp!=null){
            if(pos==left-1) a = temp;
            if(pos==left) b = temp;
            if(pos==right) c = temp;
            if(pos==right+1) d = temp;
            temp = temp.next;
            pos++;
        }
        if(a!=null) a.next = null; 
        if(c!=null) c.next = null;
        reverse(b);
        if(a!=null) a.next = c;
        b.next = d;
        if(a==null) return c;
        return head;
    }
}
