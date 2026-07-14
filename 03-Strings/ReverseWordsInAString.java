/*
Problem:
LeetCode 151 - Reverse Words in a String

Link:
https://leetcode.com/problems/reverse-words-in-a-string/

Approach:
Split + Reverse Traversal

- Split the string using one or more spaces.
- Traverse the array from the end to the beginning.
- Append each word followed by a space.
- Trim the extra space at the end.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String reverseWords(String s) {

        String[] arr = s.split("\\s+");

        String ans = "";

        for(int i = arr.length - 1; i >= 0; i--) {
            ans = ans + arr[i] + " ";
        }

        return ans.trim();
    }
}
