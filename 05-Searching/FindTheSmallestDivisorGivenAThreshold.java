/*
Problem:
LeetCode 1283 - Find the Smallest Divisor Given a Threshold

Link:
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

Approach:
Binary Search on Answer

- The divisor lies between 1 and the maximum element.
- For each candidate divisor, calculate the sum of
  ceil(arr[i] / divisor).
- If the sum is less than or equal to the threshold,
  try a smaller divisor.
- Otherwise, search for a larger divisor.

Time Complexity: O(n log M)
Space Complexity: O(1)

where M = maximum element in the array.
*/

class Solution {

    public int smallestDivisor(int[] arr, int t) {

        int divisor = 1;
        int n = arr.length;

        int lo = 1;
        int hi = -1;

        // Find maximum element
        for(int num : arr) {
            hi = Math.max(hi, num);
        }

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            int sum = 0;

            for(int num : arr) {

                if(num % mid == 0) {
                    sum += num / mid;
                } else {
                    sum += num / mid + 1;
                }
            }

            if(sum <= t) {
                divisor = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return divisor;
    }
}
