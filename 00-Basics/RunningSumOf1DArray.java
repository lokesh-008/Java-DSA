/*
Problem:
LeetCode 1480 - Running Sum of 1D Array

Link:
https://leetcode.com/problems/running-sum-of-1d-array/

Approach:
Traverse the array from index 1.
Add the previous element's running sum to the current element.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int[] runningSum(int[] nums) {

        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        return nums;
    }
}
