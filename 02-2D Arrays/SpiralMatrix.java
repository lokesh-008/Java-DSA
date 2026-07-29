/*
Problem:
LeetCode 54 - Spiral Matrix

Link:
https://leetcode.com/problems/spiral-matrix/

Approach:
Boundary Traversal

Maintain four boundaries:
- minR (top row)
- maxR (bottom row)
- minC (left column)
- maxC (right column)

Traverse:
1. Left → Right
2. Top → Bottom
3. Right → Left
4. Bottom → Top

After each traversal, shrink the corresponding boundary.

Time Complexity: O(m × n)
Space Complexity: O(1) (excluding output list)
*/

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
