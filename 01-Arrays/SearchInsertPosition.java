/*
Problem:
LeetCode 35 - Search Insert Position

Link:
https://leetcode.com/problems/search-insert-position/

Approach:
Linear Search

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == target) {
                return i;
            }

            else if(nums[i] > target) {
                return i;
            }
        }

        return nums.length;
    }
}
