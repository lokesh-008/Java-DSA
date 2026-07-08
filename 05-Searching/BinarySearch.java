/*
Problem:
LeetCode 704 - Binary Search

Link:
https://leetcode.com/problems/binary-search/

Approach:
Binary Search

- Initialize two pointers: low and high.
- Find the middle element.
- If the middle element equals the target, return its index.
- If the target is greater, search the right half.
- Otherwise, search the left half.
- Continue until the target is found or the search space becomes empty.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
