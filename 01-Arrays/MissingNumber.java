/*
Problem:
LeetCode 268 - Missing Number

Link:
https://leetcode.com/problems/missing-number/

Approach:
Use the XOR operation to find the missing number.

- The array contains n distinct numbers from the range [0, n].
- Initialize xor with n because n is not included in the loop index range.
- For every index i:
    - XOR xor with i.
    - XOR xor with nums[i].
- XOR has the property:
    - x ^ x = 0
    - x ^ 0 = x
- Therefore, all numbers that appear both in the range [0, n]
  and the array cancel each other.
- The only remaining value is the missing number.

Technique:
Bit Manipulation (XOR)

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n;

        for (int i = 0; i < n; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }
}
