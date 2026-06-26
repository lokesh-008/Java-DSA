/*
Problem:
LeetCode 2114 - Maximum Number of Words Found in Sentences

Link:
https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

Approach:
For each sentence:
- Split the sentence using spaces.
- Count the number of words.
- Keep track of the maximum count.

Time Complexity: O(n * m)
n = number of sentences
m = average sentence length

Space Complexity: O(m)
*/

class Solution {
    public int mostWordsFound(String[] sentences) {

        int max = 0;

        for(String currSent : sentences) {

            int currLen = currSent.split(" ").length;

            max = Math.max(max, currLen);
        }

        return max;
    }
}
