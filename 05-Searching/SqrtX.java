/*
Problem:
LeetCode 69 - Sqrt(x)

Link:
https://leetcode.com/problems/sqrtx/

Approach:
Binary Search

- Search between 0 and x.
- Compute mid and compare mid² with x.
- If mid² == x, return mid.
- If mid² < x, search the right half.
- Otherwise, search the left half.
- If no perfect square exists, return the floor value (hi).

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int mySqrt(int x) {

        long lo = 0;
        long hi = x;

        while(lo <= hi) {

            long mid = lo + (hi - lo) / 2;

            if(mid * mid == x) {
                return (int) mid;
            }
            else if(mid * mid < x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return (int) hi;
    }
}
