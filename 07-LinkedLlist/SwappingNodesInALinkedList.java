/*
Problem:
LeetCode 1721 - Swapping Nodes in a Linked List

Link:
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

Approach:
Length Calculation + Two Pointer Traversal

- Find the length of the linked list.
- Locate:
    - kth node from the beginning.
    - kth node from the end.
- Swap their values.
- Return the modified list.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode a = head;
        ListNode b = head;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        int idx = len - k;
        for(int i = 1; i < k; i++){
            a = a.next;
        }
        for(int i = 1; i <= idx; i++){
            b = b.next;
        }
        int x = a.val;
        a.val = b.val;
        b.val = x;
        
        return head;


    }
}
