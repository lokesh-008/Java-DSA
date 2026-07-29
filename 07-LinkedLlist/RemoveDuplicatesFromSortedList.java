/*
Problem:
LeetCode 83 - Remove Duplicates from Sorted List

Link:
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Approach:
Single Traversal + Two Pointers

- Since the list is already sorted, duplicate values appear consecutively.
- Use two pointers:
    - i points to the last unique node.
    - j scans ahead to find the next distinct value.
- Link i to the next unique node.
- After traversal, terminate the list by setting i.next = null.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode i = head;
        ListNode j = head;
        while(j != null){
            if(j.val == i.val) j = j.next;
            else{
                i.next = j;
                i = j;
            }
        }
        i.next = null;
        return head;
    }
}
