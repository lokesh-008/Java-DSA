/*
Problem:
LeetCode 1108 - Defanging an IP Address

Link:
https://leetcode.com/problems/defanging-an-ip-address/

Approach:
Use Java's replace() method to replace every '.'
with '[.]'.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String defangIPaddr(String s) {

        String a = s.replace(".", "[.]");

        return a;
    }
}



/*
Alternative Approach:

class Solution {
    public String defangIPaddr(String s) {

        String a = "";

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch != '.') {
                a += ch;
            }
            else {
                a += "[.]";
            }
        }

        return a;
    }
}
*/





