/*
Problem:
LeetCode 33 - Search in Rotated Sorted Array

Link:
https://leetcode.com/problems/search-in-rotated-sorted-array/

Approach:
Modified Binary Search

- Find the middle element.
- If it matches the target, return its index.
- Determine which half is sorted.
- Check whether the target lies in the sorted half.
- Search accordingly.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int search(int[] nums, int target) {

        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            // Right half is sorted
            else if(nums[mid] <= nums[hi]) {

                if(nums[mid] <= target && target <= nums[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }

            // Left half is sorted
            else {

                if(nums[lo] <= target && target <= nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
}
