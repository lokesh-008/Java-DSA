/*
Problem:
LeetCode 485 - Max Consecutive Ones

Link:
https://leetcode.com/problems/max-consecutive-ones/

Approach:
Traverse the array once while maintaining the current consecutive count of 1s.

- If the current element is 1, increment the count.
- Update the maximum count after every 1.
- If the current element is 0, reset the count to 0.
- Return the maximum consecutive count found.

Technique:
Array Traversal

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int mx = 0;

        for (int ele : nums) {
            if (ele == 1) {
                count++;
                mx = Math.max(mx, count);
            } else {
                count = 0;
            }
        }

        return mx;
    }
}
