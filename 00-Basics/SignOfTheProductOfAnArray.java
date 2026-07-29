/*
Problem:
LeetCode 1822 - Sign of the Product of an Array

Link:
https://leetcode.com/problems/sign-of-the-product-of-an-array/

Approach:
Instead of calculating the actual product
(which may overflow), track only its sign.

- If any element is 0, return 0.
- Count negative numbers by flipping sign.
- Even negatives => positive product.
- Odd negatives => negative product.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int arraySign(int[] nums) {

        int sign = 1;

        for(int num : nums) {

            if(num == 0) {
                return 0;
            }

            if(num < 0) {
                sign *= -1;
            }
        }

        return sign;
    }
}
