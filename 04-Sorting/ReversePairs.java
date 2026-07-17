/*
Problem:
LeetCode 493 - Reverse Pairs

Link:
https://leetcode.com/problems/reverse-pairs/

Approach:
Merge Sort + Counting Reverse Pairs

- Divide the array into two halves.
- Recursively sort both halves.
- Before merging, count reverse pairs:
      nums[i] > 2 * nums[j]
- Merge the two sorted halves.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {
    static int count;
    // Count reverse pairs
    public void inversion(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length) {
            if((long) a[i] > 2L * b[j]) {
                count += (a.length - i);
                j++;
            } else {
                i++;
            }
        }
    }
    public void mergesort(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return;
        }
        int[] left = new int[n / 2];
        int[] right = new int[n - n / 2];
        for(int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }
        for(int i = 0; i < right.length; i++) {
            right[i] = nums[i + n / 2];
        }
        mergesort(left);
        mergesort(right);
        inversion(left, right);
        merge(left, right, nums);
    }

    public void merge(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
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

    public int reversePairs(int[] nums) {
        count = 0;
        mergesort(nums);
        return count;
    }
}
