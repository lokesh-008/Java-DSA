/*
Problem:
LeetCode 1678 - Goal Parser Interpretation

Link:
https://leetcode.com/problems/goal-parser-interpretation/

Approach:
Traverse the string character by character.

Rules:
- 'G' → "G"
- "()" → "o"
- "(al)" → "al"

Use StringBuilder for efficient string construction.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String interpret(String command) {

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < command.length(); i++) {

            if(command.charAt(i) == 'G') {
                ans.append("G");
            }
            else if(command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                ans.append("o");
                i++; // Skip ')'
            }
            else if(command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                ans.append("al");
                i += 3; // Skip "al)"
            }
        }

        return ans.toString();
    }
}
