/*
Problem:
LeetCode 2058 - Find the Minimum and Maximum Number of Nodes Between Critical Points

Link:
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

Approach:
Single Traversal + Track Critical Points

- Traverse the list using three pointers:
    left, mid, right.
- A node is critical if it is either:
    • Local Maximum
    • Local Minimum
- Store the index of:
    • First critical point
    • Previous critical point
- Update:
    • Minimum distance between consecutive critical points
    • Maximum distance between first and current critical point

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode mid = left.next;
        ListNode right = mid.next;
        int first = -1, last = -1;
        int idx = 1;
        int[] arr = {-1, -1};
        int minDistance = Integer.MAX_VALUE;
        while(right!=null){
            if((mid.val < left.val && mid.val < right.val) || (mid.val > left.val && mid.val > right.val)){
                if(first == -1) first = idx;
                if(last != -1){
                    int dist = idx - last;
                    minDistance = Math.min(minDistance, dist);
                }
                last = idx;       
            }
            idx++;
            left = left.next;
            mid = mid.next;
            right = right.next;
        }
        if(first == last) return arr; // 0 or 1 critical point
        int maxDistance = last - first;
        arr[0] = minDistance;
        arr[1] = maxDistance;
        return arr;
    }
}
