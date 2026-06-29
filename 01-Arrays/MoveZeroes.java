/*
Problem:
LeetCode 283 - Move Zeroes

Link:
https://leetcode.com/problems/move-zeroes/

Approach:
Two Pointers

- Use pointer j to keep track of the position where the next
  non-zero element should be placed.
- Traverse the array once and move all non-zero elements
  to the front.
- Fill the remaining positions with zeros.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {

        int j = 0;

        // Move all non-zero elements to the front
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Fill remaining positions with zeros
        while(j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
