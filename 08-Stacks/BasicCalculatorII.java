/*
Problem:
LeetCode 227 - Basic Calculator II

Link:
https://leetcode.com/problems/basic-calculator-ii/

Approach:
Use a stack to evaluate the expression while respecting operator precedence.

- Traverse the string character by character.
- Build multi-digit numbers.
- Whenever an operator or the end of the string is reached:
    - '+' : Push the current number onto the stack.
    - '-' : Push the negative of the current number.
    - '*' : Pop the top element, multiply it with the current number, and push the result.
    - '/' : Pop the top element, divide it by the current number (truncate toward zero), and push the result.
- Update the current operation and reset the current number.
- Finally, sum all the values stored in the stack to obtain the answer.

Technique:
Stack

Time Complexity:
Traversal        -> O(n)
Stack Operations -> O(n)

Overall          -> O(n)

Space Complexity:
O(n)
*/

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Build multi-digit numbers
            if (Character.isDigit(ch)) {
                currentNumber = (currentNumber * 10) + (ch - '0');
            }

            // Process the previous operation
            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {

                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = ch;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
