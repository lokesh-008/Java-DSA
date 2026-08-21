```java
/*
Problem:
LeetCode 100 - Same Tree

Link:
https://leetcode.com/problems/same-tree/

Approach:
Use recursive Depth First Search (DFS) to compare both binary trees.

- If both nodes are null, the trees are identical at that position.
- If one node is null and the other is not, the trees are different.
- If the values of the current nodes are different, return false.
- Recursively compare the left subtrees.
- Recursively compare the right subtrees.
- Return true only if both subtrees are identical.

Technique:
Tree DFS (Recursion)

Time Complexity:
O(n)
- Each corresponding node is visited once.

Space Complexity:
O(h)
- h is the height of the tree due to the recursion stack.
- O(n) in the worst case for a skewed tree.
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        if (!isSameTree(p.right, q.right)) return false;
        if (!isSameTree(p.left, q.left)) return false;

        return true;
    }
}
```
