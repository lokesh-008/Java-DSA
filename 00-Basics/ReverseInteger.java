/*
Problem:
LeetCode 7 - Reverse Integer

Link:
https://leetcode.com/problems/reverse-integer/

Approach:
- Extract digits one by one using modulo (% 10).
- Build the reversed integer by multiplying the current answer by 10
  and adding the extracted digit.
- Before appending a digit, check whether multiplying by 10 would
  overflow a 32-bit signed integer.
- Return 0 if overflow occurs.

Technique:
Mathematical Digit Extraction + Overflow Checking

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int reverse(int x) {
        int temp = Math.abs(x);
        int ans = 0;

        while (temp > 0) {
            int digit = temp % 10;

            if (ans > Integer.MAX_VALUE / 10 ||
                (ans == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            ans = ans * 10 + digit;
            temp /= 10;
        }

        return x < 0 ? -ans : ans;
    }
}
