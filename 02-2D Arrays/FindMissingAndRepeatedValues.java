/*
Problem:
LeetCode 2965 - Find Missing and Repeated Values

Link:
https://leetcode.com/problems/find-missing-and-repeated-values/

Approach:
Frequency Array

- Create a frequency array of size n² + 1.
- Traverse the matrix and count the occurrence of each number.
- Traverse the frequency array:
    - Frequency 2 → Repeated number
    - Frequency 0 → Missing number

Return both values.

Time Complexity: O(n²)
Space Complexity: O(n²)
*/

class Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int[] ans = new int[2];

        int[] freq = new int[n * n + 1];

        // Count frequencies
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                int curr = grid[i][j];
                freq[curr]++;
            }
        }

        // Find repeated and missing values
        for(int i = 1; i < freq.length; i++) {

            if(freq[i] == 2) {
                ans[0] = i;
            }
            else if(freq[i] == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }
}v
