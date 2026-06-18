/*
Problem:
LeetCode 53 - Maximum Subarray

Link:
https://leetcode.com/problems/maximum-subarray/

Approach:
Kadane's Algorithm

At each index:
- Either start a new subarray from the current element
- Or extend the previous subarray

Keep track of:
- Current Sum (cs)
- Maximum Sum (ms)

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {

        int ms = nums[0];
        int cs = nums[0];

        for(int i = 1; i < nums.length; i++) {

            cs = Math.max(nums[i], cs + nums[i]);

            ms = Math.max(cs, ms);
        }

        return ms;
    }
}
