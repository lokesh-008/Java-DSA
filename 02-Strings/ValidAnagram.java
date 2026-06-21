/*
Problem:
LeetCode 242 - Valid Anagram

Link:
https://leetcode.com/problems/valid-anagram/

Approach:
Convert both strings to character arrays.
Sort both arrays.
Compare corresponding characters.

If all characters match, the strings are anagrams.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
