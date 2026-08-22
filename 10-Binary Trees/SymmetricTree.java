```java
/*
Problem:
LeetCode 101 - Symmetric Tree

Link:
https://leetcode.com/problems/symmetric-tree/

Approach:
Use recursion to check whether the left and right subtrees are mirror images.

- If both nodes are null, they are symmetric.
- If one node is null or their values are different, they are not symmetric.
- Compare the left subtree of the first node with the right subtree of the second node.
- Compare the right subtree of the first node with the left subtree of the second node.
- The tree is symmetric only if both comparisons are true.

Technique:
Tree DFS (Recursion)

Time Complexity:
O(n)
- Each node is visited once.

Space Complexity:
O(h)
- h is the height of the tree due to the recursion stack.
- O(n) in the worst case for a skewed tree.
*/

class Solution {

    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return isMirror(node1.left, node2.right)
            && isMirror(node1.right, node2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }
}
```
