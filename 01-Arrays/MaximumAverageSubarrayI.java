/*
Problem:
LeetCode 643 - Maximum Average Subarray I

Link:
https://leetcode.com/problems/maximum-average-subarray-i/

Approach:
Sliding Window

- Compute the sum of the first k elements.
- Store it as the initial maximum sum.
- Slide the window one element at a time:
    - Add the new element entering the window.
    - Remove the element leaving the window.
- Update the maximum sum.
- Return the maximum average.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public double findMaxAverage(int[] nums, int k) {

        int maxSum = 0;
        int currSum = 0;

        // Initial window
        for(int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        maxSum = currSum;

        // Slide the window
        for(int i = k; i < nums.length; i++) {

            currSum = currSum + nums[i] - nums[i - k];

            maxSum = Math.max(maxSum, currSum);
        }

        return (double) maxSum / k;
    }
}
