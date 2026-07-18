/*
Problem:
LeetCode 215 - Kth Largest Element in an Array

Link:
https://leetcode.com/problems/kth-largest-element-in-an-array/

Approach:
Quick Select (Randomized Pivot + Dutch National Flag Partition)

- Convert kth largest to (n-k)th smallest.
- Choose a random pivot.
- Partition the array into:
    - Elements less than pivot
    - Elements equal to pivot
    - Elements greater than pivot
- Recursively search only the partition containing the answer.

Time Complexity:
Average: O(n)
Worst: O(n²)

Space Complexity:
Average: O(log n) (Recursion Stack)
Worst: O(n)
*/

import java.util.Random;

class Solution {

    private Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {

        if(left == right) {
            return nums[left];
        }

        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivot = nums[pivotIndex];

        int lt = left;
        int i = left;
        int gt = right;

        while(i <= gt) {

            if(nums[i] < pivot) {
                swap(nums, i, lt);
                i++;
                lt++;
            }
            else if(nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            }
            else {
                i++;
            }
        }

        if(k >= lt && k <= gt) {
            return nums[k];
        }
        else if(k < lt) {
            return quickSelect(nums, left, lt - 1, k);
        }
        else {
            return quickSelect(nums, gt + 1, right, k);
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
