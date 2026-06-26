/*
Problem:
LeetCode 54 - Spiral Matrix

Link:
https://leetcode.com/problems/spiral-matrix/

Approach:
Use four boundaries to traverse the matrix in spiral order.

- Traverse Left → Right
- Traverse Top → Bottom
- Traverse Right → Left
- Traverse Bottom → Top

After each traversal, update the corresponding boundary.
Repeat until all elements are visited.

Time Complexity: O(m × n)
Space Complexity: O(1) (excluding output list)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        int m = arr.length;
        int n = arr[0].length;

        int minR = 0;
        int maxR = m - 1;
        int minC = 0;
        int maxC = n - 1;

        while(minR <= maxR && minC <= maxC) {

            // Left to Right
            for(int j = minC; j <= maxC; j++) {
                ans.add(arr[minR][j]);
            }
            minR++;

            // Top to Bottom
            if(minR > maxR || minC > maxC) break;
            for(int i = minR; i <= maxR; i++) {
                ans.add(arr[i][maxC]);
            }
            maxC--;

            // Right to Left
            if(minR > maxR || minC > maxC) break;
            for(int j = maxC; j >= minC; j--) {
                ans.add(arr[maxR][j]);
            }
            maxR--;

            // Bottom to Top
            if(minR > maxR || minC > maxC) break;
            for(int i = maxR; i >= minR; i--) {
                ans.add(arr[i][minC]);
            }
            minC++;
        }

        return ans;
    }
}
