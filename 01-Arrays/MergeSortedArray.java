/*
Problem:
LeetCode 88 - Merge Sorted Array

Link:
https://leetcode.com/problems/merge-sorted-array/

Approach:
Copy all elements from nums2 into the remaining positions
of nums1. Then sort the entire array using Arrays.sort().

Time Complexity: O((m + n) log(m + n))
Space Complexity: O(1)
*/

import java.util.Arrays;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int x = 0;

        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[x];
            x++;
        }

        Arrays.sort(nums1);
    }
}
