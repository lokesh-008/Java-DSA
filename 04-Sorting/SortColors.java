/*
Problem:
LeetCode 75 - Sort Colors

Link:
https://leetcode.com/problems/sort-colors/

Approach:
Dutch National Flag Algorithm

Maintain three pointers:
- low: next position for 0
- mid: current element
- high: next position for 2

Rules:
- If arr[mid] == 0:
    Swap with low, increment low and mid.
- If arr[mid] == 1:
    Just increment mid.
- If arr[mid] == 2:
    Swap with high and decrement high.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public void sortColors(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) {

            if(arr[mid] == 0) {

                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                low++;
                mid++;
            }
            else if(arr[mid] == 1) {

                mid++;
            }
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }
}
