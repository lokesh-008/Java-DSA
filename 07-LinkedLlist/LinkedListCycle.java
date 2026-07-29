/*
Problem:
LeetCode 141 - Linked List Cycle

Link:
https://leetcode.com/problems/linked-list-cycle/

Approach:
Floyd's Cycle Detection (Tortoise and Hare)

- Initialize two pointers:
    - slow moves one step at a time.
    - fast moves two steps at a time.
- If the list contains a cycle, the two pointers will eventually meet.
- If fast reaches the end of the list, there is no cycle.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
        
    }
}
