/*
Problem:
LeetCode 118 - Pascal's Triangle

Link:
https://leetcode.com/problems/pascals-triangle/

Approach:
Generate each row one by one.
First and last elements of every row are 1.
Middle elements are the sum of two elements from the previous row.

Time Complexity: O(n²)
Space Complexity: O(n²)
*/

class Solution {
    public List<List<Integer>> generate(int n) {

        ArrayList<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            List<Integer> l = new ArrayList<>();

            for(int j = 0; j <= i; j++) {

                if(j == 0 || j == i) {
                    l.add(1);
                }
                else {
                    l.add(ans.get(i - 1).get(j)
                          + ans.get(i - 1).get(j - 1));
                }
            }

            ans.add(l);
        }

        return ans;
    }
}
