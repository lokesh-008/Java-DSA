/*
Problem:
LeetCode 658 - Find K Closest Elements

Link:
https://leetcode.com/problems/find-k-closest-elements/

Approach:
Binary Search + Two Pointers

1. Handle edge cases:
   - If x is smaller than the first element.
   - If x is larger than the last element.
2. Find the Lower Bound of x using Binary Search.
3. Expand outward using two pointers to collect the k closest elements.
4. Sort the final answer before returning.

Time Complexity: O(log n + k log k)
Space Complexity: O(k)
*/

import java.util.*;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> ans = new ArrayList<>();

        int n = arr.length;

        // x is smaller than all elements
        if(x < arr[0]) {
            for(int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        // x is greater than all elements
        if(x > arr[n - 1]) {
            for(int i = n - 1; i >= n - k; i--) {
                ans.add(arr[i]);
            }
            Collections.sort(ans);
            return ans;
        }

        // Lower Bound
        int lb = n;
        int lo = 0;
        int hi = n - 1;

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if(arr[mid] >= x) {
                lb = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        int i = lb - 1;
        int j = lb;

        while(k > 0 && i >= 0 && j < n) {

            int leftDiff = Math.abs(x - arr[i]);
            int rightDiff = Math.abs(x - arr[j]);

            if(leftDiff <= rightDiff) {
                ans.add(arr[i]);
                i--;
            } else {
                ans.add(arr[j]);
                j++;
            }

            k--;
        }

        while(i >= 0 && k > 0) {
            ans.add(arr[i]);
            i--;
            k--;
        }

        while(j < n && k > 0) {
            ans.add(arr[j]);
            j++;
            k--;
        }

        Collections.sort(ans);

        return ans;
    }
}
