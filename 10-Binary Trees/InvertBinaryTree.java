```java
/*
Problem:
LeetCode 226 - Invert Binary Tree

Link:
https://leetcode.com/problems/invert-binary-tree/

Approach:
Use recursion to swap the left and right subtrees of every node.

- If the current node is null, return null.
- Recursively invert the right subtree and store it in temp.
- Recursively invert the left subtree and assign it to root.right.
- Assign the previously inverted right subtree to root.left.
- Return the root after both subtrees have been swapped.

Technique:
Tree DFS (Recursion)

Time Complexity:
O(n)
- Every node is visited once.

Space Complexity:
O(h)
- h is the height of the tree due to the recursion stack.
- O(n) in the worst case for a skewed tree.
*/

class Solution {

    public TreeNode invert(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = invert(root.right);
        root.right = invert(root.left);
        root.left = temp;

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
}
```
