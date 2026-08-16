```java
/*
Problem:
LeetCode 387 - First Unique Character in a String

Link:
https://leetcode.com/problems/first-unique-character-in-a-string/

Approach:
Use a frequency array to count the occurrence of each character.

- Create a frequency array of size 26 for lowercase English letters.
- Traverse the string and increment the frequency of each character.
- Traverse the string again from left to right.
- The first character whose frequency is 1 is the first unique character.
- Return its index.
- If no unique character exists, return -1.

Technique:
Frequency Array

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
```
