/*
Problem:
LeetCode 540 - Single Element in a Sorted Array

Link:
https://leetcode.com/problems/single-element-in-a-sorted-array/

Approach:
Binary Search

- In a sorted array, duplicate elements appear in pairs.
- Before the single element, pairs start at even indices.
- After the single element, this pattern breaks.
- Make mid even and compare nums[mid] with nums[mid + 1].
- If they are equal, the single element lies on the right.
- Otherwise, it lies on the left (including mid).

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int singleNonDuplicate(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if(mid % 2 == 1) {
                mid--;
            }

            if(nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            }
            else {
                hi = mid;
            }
        }

        return nums[lo];
    }
}
