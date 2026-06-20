/*
Problem:
LeetCode 27 - Remove Element

Link:
https://leetcode.com/problems/remove-element/

Approach:
Two Pointer

Use pointer k to track the position where the next
valid element should be placed.

Traverse the array:
- If nums[i] is not equal to val,
  place it at nums[k] and increment k.

The first k elements of the array will contain
all elements except val.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
