/*
Problem:
LeetCode 121 - Best Time to Buy and Sell Stock

Link:
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Approach:
Keep track of the minimum buying price seen so far.
For each day, calculate the profit if sold today.
Update the maximum profit accordingly.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {

            if(prices[i] < buy) {
                buy = prices[i];
            }

            else if(prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        return profit;
    }
}
