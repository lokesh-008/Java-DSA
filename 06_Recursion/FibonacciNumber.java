/*
Problem:
LeetCode 509 - Fibonacci Number

Link:
https://leetcode.com/problems/fibonacci-number/

Approach:
Recursion

- If n is 0 or 1, return n.
- Otherwise, recursively compute:
    fib(n - 1) + fib(n - 2)

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

class Solution {

    public int fib(int n) {

        if(n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
