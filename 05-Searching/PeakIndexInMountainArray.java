/*
Problem:
LeetCode 852 - Peak Index in a Mountain Array

Link:
https://leetcode.com/problems/peak-index-in-a-mountain-array/

Approach:
Binary Search

- The peak element is greater than both its adjacent elements.
- If the current element is increasing, move to the right.
- Otherwise, move to the left.
- Continue until the peak is found.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;

        int lo = 1;
        int hi = n - 2;

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if(arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
