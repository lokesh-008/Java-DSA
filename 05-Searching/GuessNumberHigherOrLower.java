/*
Problem:
LeetCode 374 - Guess Number Higher or Lower

Link:
https://leetcode.com/problems/guess-number-higher-or-lower/

Approach:
Use Binary Search to find the picked number between 1 and n.

- Set the search range from 1 to n.
- Calculate the middle value.
- Use the guess() API to determine the next search range:
    - guess(mid) == 0:
        mid is the picked number, so return mid.
    - guess(mid) == 1:
        mid is lower than the picked number, so search the right half.
    - guess(mid) == -1:
        mid is higher than the picked number, so search the left half.
- Continue until the picked number is found.

Technique:
Binary Search

Time Complexity:
O(log n)

Space Complexity:
O(1)
*/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
