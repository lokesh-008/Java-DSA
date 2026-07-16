/*
Problem:
LeetCode 58 - Length of Last Word

Link:
https://leetcode.com/problems/length-of-last-word/

Approach:
Split String

- Split the string using one or more spaces.
- Access the last word in the resulting array.
- Return its length.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int lengthOfLastWord(String s) {

        String[] words = s.split("\\s+");

        return words[words.length - 1].length();
    }
}
