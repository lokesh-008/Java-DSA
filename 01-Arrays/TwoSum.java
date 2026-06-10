/*
Problem:
LeetCode 1 - Two Sum

Link:
https://leetcode.com/problems/two-sum/

Approach:
Brute Force

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        boolean flag = false;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag == true) break;
        }
        return ans;
    }
}
