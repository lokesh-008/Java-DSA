```java
/*
Problem:
LeetCode 543 - Diameter of Binary Tree

Link:
https://leetcode.com/problems/diameter-of-binary-tree/

Approach:
Use recursion to calculate the height of every subtree and evaluate the
diameter passing through each node.

- `levels(root)` calculates the height of the current subtree.
- For every node, the diameter passing through it is:
    height(left) + height(right)
- Recursively calculate the diameter of the left and right subtrees.
- Return the maximum among:
    - Diameter passing through the current node
    - Diameter of the left subtree
    - Diameter of the right subtree
- The diameter is measured in number of edges.

Technique:
Tree DFS (Recursion)

Time Complexity:
O(n²)
- `levels()` may traverse the subtree repeatedly for every node.

Space Complexity:
O(h)
- h is the height of the tree due to recursion.
- O(n) in the worst case for a skewed tree.
*/

class Solution {
    public int levels(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int dia = levels(root.left) + levels(root.right);

        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);

        return Math.max(dia, Math.max(leftDia, rightDia));
    }
}
```
