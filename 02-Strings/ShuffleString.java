/*
Problem:
LeetCode 1528 - Shuffle String

Link:
https://leetcode.com/problems/shuffle-string/

Approach:
Create a character array of the same length as the string.
Place each character at its target position using the indices array.
Convert the character array back to a string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String restoreString(String s, int[] indices) {

        char[] ans = new char[s.length()];

        for(int i = 0; i < s.length(); i++) {
            ans[indices[i]] = s.charAt(i);
        }

        return new String(ans);
    }
}
