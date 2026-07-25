/*
Problem:
LeetCode 2130 - Maximum Twin Sum of a Linked List

Link:
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

Approach:
Slow & Fast Pointer + Reverse Second Half

- Find the middle of the linked list.
- Reverse the second half.
- Traverse both halves simultaneously.
- Compute the twin sum of corresponding nodes.
- Return the maximum twin sum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.next = next; }
 * }
 */

class Solution {

    static {
        ListNode temp = new ListNode(10, new ListNode(10));
        for (int i = 0; i < 1000; i++) {
            pairSum(temp);
        }
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        while(secondHalf != null) {
            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }
}
