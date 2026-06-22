/*
Problem:
LeetCode 3232 - Find if Digit Game Can Be Won

Link:
https://leetcode.com/problems/find-if-digit-game-can-be-won/

Approach:
Calculate:
- sumA = sum of all single-digit numbers
- sumB = sum of all double-digit numbers

Alice wins if the sums are different.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean canAliceWin(int[] nums) {

        int sumA = 0;
        int sumB = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] < 10) {
                sumA += nums[i];
            }
            else {
                sumB += nums[i];
            }
        }

        if(sumA == sumB) {
            return false;
        }

        return true;
    }
}
