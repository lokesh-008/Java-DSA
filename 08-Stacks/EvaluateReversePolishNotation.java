/*
Problem:
LeetCode 150 - Evaluate Reverse Polish Notation

Link:
https://leetcode.com/problems/evaluate-reverse-polish-notation/

Approach:
Use a stack to evaluate the Reverse Polish Notation (Postfix Expression).

- Traverse each token in the given array.
- If the token is an operand, convert it to an integer and push it onto the stack.
- If the token is an operator:
    - Pop the top two operands from the stack.
    - The first popped value is the second operand (v2).
    - The second popped value is the first operand (v1).
    - Perform the corresponding operation.
    - Push the result back onto the stack.
- After processing all the tokens, the remaining element in the stack is the final answer.

Technique:
Stack

Time Complexity:
Traversal        -> O(n)
Stack Operations -> O(1) per operation

Overall          -> O(n)

Space Complexity:
O(n)
*/

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> val = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int v2 = val.pop();
                int v1 = val.pop();

                if (token.equals("+")) {
                    val.push(v1 + v2);
                } else if (token.equals("-")) {
                    val.push(v1 - v2);
                } else if (token.equals("*")) {
                    val.push(v1 * v2);
                } else {
                    val.push(v1 / v2);
                }

            } else {
                val.push(Integer.parseInt(token));
            }
        }

        return val.peek();
    }
}
