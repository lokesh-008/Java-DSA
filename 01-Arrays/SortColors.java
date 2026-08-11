/*
Problem:
LeetCode 75 - Sort Colors

Link:
https://leetcode.com/problems/sort-colors/

Approach:
Use the Dutch National Flag algorithm with three pointers.

- `lo` points to the position where the next 0 should be placed.
- `mid` scans the array.
- `hi` points to the position where the next 2 should be placed.
- If arr[mid] is 0:
    - Swap it with arr[lo].
    - Increment both lo and mid.
- If arr[mid] is 1:
    - It is already in the correct region.
    - Increment mid.
- If arr[mid] is 2:
    - Swap it with arr[hi].
    - Decrement hi.
    - Do not increment mid because the swapped element still needs to be checked.

Technique:
Dutch National Flag Algorithm (Three Pointers)

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

class Solution {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] arr) {
        int lo = 0;
        int mid = 0;
        int hi = arr.length - 1;

        while (mid <= hi) {
            if (arr[mid] == 0) {
                swap(arr, lo, mid);
                lo++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, hi, mid);
                hi--;
            }
        }
    }
}
