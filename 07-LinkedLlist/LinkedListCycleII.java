/*
Problem:
LeetCode 142 - Linked List Cycle II

Link:
https://leetcode.com/problems/linked-list-cycle-ii/

Approach:
Floyd's Cycle Detection + Find Cycle Start

- Use slow and fast pointers to detect whether a cycle exists.
- If no cycle is found, return null.
- If they meet, place another pointer at the head.
- Move both pointers one step at a time.
- The node where they meet again is the starting node of the cycle.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s==f) break;
        }
        if(s != f) return null;
        ListNode t = head;
        while(t != s){
            s = s.next;
            t = t.next;
        }
        return t;
    }
}
