/*
Problem:
LeetCode 367 - Valid Perfect Square

Link:
https://leetcode.com/problems/valid-perfect-square/

Approach:
Binary Search

- Search between 0 and num.
- Calculate the middle value.
- Compare mid² with num.
- If equal, return true.
- If mid² is greater, search the left half.
- Otherwise, search the right half.

Use long to avoid integer overflow while computing mid².

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPerfectSquare(int num) {

        if(num == 0 || num == 1) {
            return true;
        }

        int lo = 0;
        int hi = num;

        while(lo <= hi) {

            long mid = lo + (hi - lo) / 2;

            if(mid * mid == num) {
                return true;
            }
            else if(mid * mid > num) {
                hi = (int) mid - 1;
            }
            else {
                lo = (int) mid + 1;
            }
        }

        return false;
    }
}
