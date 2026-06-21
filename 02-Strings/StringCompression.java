/*
Problem:
LeetCode 443 - String Compression

Link:
https://leetcode.com/problems/string-compression/

Approach:
Two Pointers

- Use i to mark the start of a group.
- Use j to find the end of the group.
- Append the character and its count (if > 1)
  to a StringBuilder.
- Copy the compressed string back into the array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int compress(char[] arr) {

        StringBuilder sb = new StringBuilder("");

        int i = 0;
        int j = 0;

        while(j < arr.length) {

            if(arr[i] == arr[j]) {
                j++;
            }
            else {

                sb.append(arr[i]);

                int len = j - i;

                if(len > 1) {
                    sb.append(len);
                }

                i = j;
            }
        }

        sb.append(arr[i]);

        int len = j - i;

        if(len > 1) {
            sb.append(len);
        }

        for(i = 0; i < sb.length(); i++) {
            arr[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
