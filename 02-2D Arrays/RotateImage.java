/*
Problem:
LeetCode 48 - Rotate Image

Link:
https://leetcode.com/problems/rotate-image/

Approach:
1. Transpose the matrix.
2. Reverse each row by swapping columns.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        // Transpose
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse Columns
        int a = 0;
        int b = m - 1;

        while(a < b) {

            for(int i = 0; i < m; i++) {

                int temp = arr[i][a];
                arr[i][a] = arr[i][b];
                arr[i][b] = temp;
            }

            a++;
            b--;
        }
    }
}
