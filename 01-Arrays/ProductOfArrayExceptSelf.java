/*
Problem:
LeetCode 238 - Product of Array Except Self

Link:
https://leetcode.com/problems/product-of-array-except-self/

Approach:
Product + Zero Counting

- Calculate the product of all non-zero elements.
- Count the number of zeros in the array.
- If there are:
    - No zeros: answer = total product / current element.
    - One zero: only the zero position gets the product.
    - More than one zero: every answer is zero.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int product = 1;
        int zeroCount = 0;

        for(int num : nums) {

            if(num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        for(int i = 0; i < n; i++) {

            if(nums[i] != 0) {

                if(zeroCount == 0) {
                    nums[i] = product / nums[i];
                } else {
                    nums[i] = 0;
                }

            } else {

                if(zeroCount == 1) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            }
        }

        return nums;
    }
}
