/*
Problem:
LeetCode 1470 - Shuffle the Array

Link:
https://leetcode.com/problems/shuffle-the-array/

Approach:
Use three pointers:
- k points to the first half of the array.
- j points to the second half.
- i points to the current index in the answer array.

Alternately place elements from the first and second halves
into the result array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[n * 2];

        int i = 0;
        int j = n;
        int k = 0;

        while(j < n * 2) {

            if(i % 2 == 0) {
                ans[i] = nums[k];
                k++;
            }
            else {
                ans[i] = nums[j];
                j++;
            }

            i++;
        }

        return ans;
    }
}
