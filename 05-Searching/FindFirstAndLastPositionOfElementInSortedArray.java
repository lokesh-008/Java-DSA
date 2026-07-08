/*
Problem:
LeetCode 34 - Find First and Last Position of Element in Sorted Array

Link:
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Approach:
Binary Search + Lower Bound + Upper Bound

Steps:
1. Perform Binary Search to check whether the target exists.
2. Find the Lower Bound (first occurrence).
3. Find the Upper Bound (first element greater than target).
4. The answer is:
   - First Position = Lower Bound
   - Last Position = Upper Bound - 1

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};

        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        int lb = n;
        int ub = n;

        boolean found = false;

        // Check if target exists
        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] == target) {
                found = true;
                break;
            }
            else if(nums[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        if(!found) {
            return ans;
        }

        // Lower Bound
        lo = 0;
        hi = n - 1;

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] >= target) {
                lb = Math.min(lb, mid);
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        // Upper Bound
        lo = 0;
        hi = n - 1;

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] > target) {
                ub = Math.min(ub, mid);
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        ans[0] = lb;
        ans[1] = ub - 1;

        return ans;
    }
}
