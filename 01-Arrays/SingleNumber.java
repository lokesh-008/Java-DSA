/*
Problem:
LeetCode 136 - Single Number

Link:
https://leetcode.com/problems/single-number/

Approach:
Bit Manipulation (XOR)

Properties of XOR:
- a ^ a = 0
- a ^ 0 = a
- XOR is commutative and associative

All duplicate numbers cancel each other out,
leaving only the single number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int xorr = 0;
        for(int num : nums) {
            xorr ^= num;
        }
        return xorr;
    }
}
