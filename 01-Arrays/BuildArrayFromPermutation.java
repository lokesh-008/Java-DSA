/*
Problem:
LeetCode 1920 - Build Array from Permutation

Link:
https://leetcode.com/problems/build-array-from-permutation/

Approach:
Create a new array of the same size.
For each index i, place nums[nums[i]] into the answer array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] buildArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
