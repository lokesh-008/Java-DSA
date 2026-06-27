/*
Problem:
LeetCode 1903 - Largest Odd Number in String

Link:
https://leetcode.com/problems/largest-odd-number-in-string/

Approach:
Traverse the string from right to left.
The first odd digit encountered marks the end of the
largest odd-numbered prefix.

Return the substring from index 0 to that position.
If no odd digit exists, return an empty string.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public String largestOddNumber(String num) {

        int n = num.length();

        for(int i = n - 1; i >= 0; i--) {

            if((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
