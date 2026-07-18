/*
Problem:
LeetCode 448 - Find All Numbers Disappeared in an Array

Link:
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Approach:
Cyclic Sort

- Place every number at its correct index (value - 1).
- Skip numbers already in the correct position or duplicates.
- After rearranging, every index i where
  arr[i] != i + 1 represents a missing number.

Time Complexity: O(n)
Space Complexity: O(1) (excluding output list)
*/

import java.util.*;

class Solution {

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] arr) {

        List<Integer> ans = new ArrayList<>();

        int n = arr.length;
        int i = 0;

        while(i < n) {

            int ele = arr[i];

            if(ele == i + 1 || ele == arr[ele - 1]) {
                i++;
            } else {
                swap(i, ele - 1, arr);
            }
        }

        for(i = 0; i < n; i++) {
            if(arr[i] != i + 1) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
