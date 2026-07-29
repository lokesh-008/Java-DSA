/*
Problem:
LeetCode 1929 - Concatenation of Array

Link:
https://leetcode.com/problems/concatenation-of-array/

Approach:
Create a new array of size 2 * n.
Copy each element twice:
- First copy at index i.
- Second copy at index i + n.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n * 2];

        for(int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}
