/*
Problem:
LeetCode 1389 - Create Target Array in the Given Order

Link:
https://leetcode.com/problems/create-target-array-in-the-given-order/

Approach:
Use an ArrayList to dynamically insert each element
at the specified index.

After constructing the list, copy its elements into
an integer array and return it.

Time Complexity: O(n²)
Space Complexity: O(n)
*/

import java.util.ArrayList;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] target = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }

        return target;
    }
}v
