/*
Problem:
LeetCode 66 - Plus One

Link:
https://leetcode.com/problems/plus-one/

Approach:
Traverse from the last digit.
If digit < 9, increment and return.
If digit = 9, make it 0 and carry forward.
If all digits are 9, create a new array with leading 1.

Time Complexity: O(n)
Space Complexity: O(1) (excluding output array)
*/

class Solution {
    public int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i--) {

            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
