/*
Problem:
LeetCode 169 - Majority Element

Link:
https://leetcode.com/problems/majority-element/

Approach:
Insertion Sort

Sort the array using Insertion Sort.
Since the majority element appears more than n/2 times,
it will always occupy the middle position after sorting.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public int majorityElement(int[] nums) {

        int n = nums.length;

        // Insertion Sort
        for(int i = 1; i < n; i++) {

            for(int j = i; j > 0; j--) {

                if(nums[j] < nums[j - 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;

                } else {
                    break;
                }
            }
        }

        return nums[n / 2];
    }
}
