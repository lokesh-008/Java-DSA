/*
Problem:
LeetCode 977 - Squares of a Sorted Array

Link:
https://leetcode.com/problems/squares-of-a-sorted-array/

Approach:
Two Pointers

Since the array is sorted, the largest square can come
from either the leftmost negative number or the rightmost
positive number.

Compare their squares and place the larger one at the
end of the result array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;
        int idx = n - 1;

        while(left <= right) {

            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if(leftSq > rightSq) {
                ans[idx] = leftSq;
                left++;
            }
            else {
                ans[idx] = rightSq;
                right--;
            }

            idx--;
        }

        return ans;
    }
}
