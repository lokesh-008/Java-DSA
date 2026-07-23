/*
Problem:
LeetCode 160 - Intersection of Two Linked Lists

Link:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Approach:
Length Difference + Two Pointers

- Find the length of both linked lists.
- Move the pointer of the longer list ahead by the difference in lengths.
- Traverse both lists together.
- The first common node is the intersection.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode ha = headA;
        ListNode hb = headB;
        while(ha != null) {
            lenA++;
            ha = ha.next;
        }
        while(hb != null) {
            lenB++;
            hb = hb.next;
        }
        ha = headA;
        hb = headB;
        if(lenA > lenB) {
            for(int i = 0; i < lenA - lenB; i++) {
                ha = ha.next;
            }
        } else {
            for(int i = 0; i < lenB - lenA; i++) {
                hb = hb.next;
            }
        }
        while(ha != hb) {
            ha = ha.next;
            hb = hb.next;
        }
        return ha;
    }
}
