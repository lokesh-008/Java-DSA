/*
Problem:
LeetCode 84 - Largest Rectangle in Histogram

Link:
https://leetcode.com/problems/largest-rectangle-in-histogram/

Approach:
Use a Monotonic Increasing Stack to find the Previous Smaller Element (PSE)
and Next Smaller Element (NSE) for every histogram bar.

- Traverse from right to left to compute the Next Smaller Element (NSE).
- Traverse from left to right to compute the Previous Smaller Element (PSE).
- For every bar, the rectangle can expand from (PSE + 1) to (NSE - 1).
- Width = NSE - PSE - 1
- Area = heights[i] × Width
- Compute the area for every bar and return the maximum area.

Technique:
Monotonic Increasing Stack (Next Smaller Element + Previous Smaller Element)

Time Complexity:
Finding NSE        -> O(n)
Finding PSE        -> O(n)
Area Calculation   -> O(n)

Overall            -> O(n)

Space Complexity:
O(n)
*/

class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Next Smaller Element
        st.push(n - 1);
        nse[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // Previous Smaller Element
        st.push(0);
        pse[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
