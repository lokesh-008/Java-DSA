/*
Problem:
LeetCode 23 - Merge k Sorted Lists

Link:
https://leetcode.com/problems/merge-k-sorted-lists/

Approach:
Merge Sort (Pairwise Merging)

- Merge the linked lists in pairs.
- After each round, the number of lists becomes approximately half.
- Repeat until only one sorted list remains.

Time Complexity: O(N log k)
Space Complexity: O(k)

where:
N = Total number of nodes
k = Number of linked lists
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.next = next; }
 * }
 */

class Solution {
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(a != null && b != null) {
            if(a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if(a == null) {
            temp.next = b;
        } else {
            temp.next = a;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        while(arr.length > 1) {
            ArrayList<ListNode> merged = new ArrayList<>();
            for(int i = 0; i < arr.length; i += 2) {
                ListNode a = arr[i];
                ListNode b = (i + 1 < arr.length) ? arr[i + 1] : null;
                merged.add(merge(a, b));
            }
            arr = merged.toArray(new ListNode[0]);
        }

        return arr[0];
    }
}
