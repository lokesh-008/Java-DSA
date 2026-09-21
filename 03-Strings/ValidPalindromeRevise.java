/*
Problem: Valid Palindrome
Link: https://leetcode.com/problems/valid-palindrome/

Approach:
Use two pointers from both ends of the string.
Skip non-alphanumeric characters and compare valid characters
while ignoring case.

Technique: Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
