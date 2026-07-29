/*
Problem:
LeetCode 1431 - Kids With the Greatest Number of Candies

Link:
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

Approach:
1. Find the maximum number of candies among all kids.
2. For each kid, check if adding extraCandies makes their candies
   greater than or equal to the maximum.
3. Store the result in a boolean list.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] arr, int ec) {

        ArrayList<Boolean> res = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] + ec >= max) {
                res.add(true);
            }
            else {
                res.add(false);
            }
        }

        return res;
    }
}
