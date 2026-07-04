/*
Problem:
LeetCode 125 - Valid Palindrome

Link:
https://leetcode.com/problems/valid-palindrome/

Approach:
- Convert the string to lowercase.
- Remove all non-alphanumeric characters.
- Reverse the cleaned string.
- Compare the original cleaned string with the reversed string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean isPalindrome(String s) {

        String clean = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        String rev = new StringBuilder(clean).reverse().toString();

        return clean.equals(rev);
    }
}
