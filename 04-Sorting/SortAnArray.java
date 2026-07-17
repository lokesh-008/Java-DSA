/*
Problem:
LeetCode 912 - Sort an Array

Link:
https://leetcode.com/problems/sort-an-array/

Approach:
Merge Sort

- Divide the array into two halves.
- Recursively sort both halves.
- Merge the two sorted halves into the original array.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {

    // Merge two sorted arrays
    public static void merge(int[] a, int[] b, int[] c) {

        int i = 0, j = 0, k = 0;

        while(i < a.length && j < b.length) {

            if(a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while(i < a.length) {
            c[k++] = a[i++];
        }

        while(j < b.length) {
            c[k++] = b[j++];
        }
    }

    public int[] sortArray(int[] nums) {

        int n = nums.length;

        // Base Case
        if(n <= 1) {
            return nums;
        }

        // Divide
        int[] left = new int[n / 2];
        int[] right = new int[n - n / 2];

        // Copy elements
        for(int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }

        for(int i = 0; i < right.length; i++) {
            right[i] = nums[i + n / 2];
        }

        // Recursively sort
        sortArray(left);
        sortArray(right);

        // Merge
        merge(left, right, nums);

        return nums;
    }
}
