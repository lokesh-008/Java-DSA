/*
Problem:
LeetCode 1365 - How Many Numbers Are Smaller Than the Current Number

Link:
https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

Approach:
Brute Force

For each element, compare it with every other element.
Count how many numbers are smaller and store the count
in the answer array.

Time Complexity: O(n²)
Space Complexity: O(n)
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {

            int count = 0;

            for(int j = 0; j < nums.length; j++) {

                if(nums[j] < nums[i]) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}
