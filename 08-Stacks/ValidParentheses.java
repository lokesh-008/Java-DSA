/*
Problem:
LeetCode 20 - Valid Parentheses

Link:
https://leetcode.com/problems/valid-parentheses/

Approach:
- Traverse the string from left to right.
- Push every opening bracket onto the stack.
- When a closing bracket is encountered:
    - If the stack is empty, return false.
    - If the top of the stack contains the matching opening bracket,
      pop it.
    - Otherwise, the parentheses are invalid.
- After processing the entire string, the stack should be empty.

Technique:
Stack

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.size()==0) return false;
                if(ch == ')' && st.peek() == '(') st.pop();
                else if(ch == '}' && st.peek() == '{') st.pop();
                else if(ch == ']' && st.peek() == '[') st.pop(); 
                else st.push(ch);
            }
        }
        if(st.size()>0) return false;
        else return true;
    }
}
