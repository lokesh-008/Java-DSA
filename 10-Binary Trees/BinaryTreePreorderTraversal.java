```java
/*
Problem:
LeetCode 144 - Binary Tree Preorder Traversal

Link:
https://leetcode.com/problems/binary-tree-preorder-traversal/

Approach:
Use recursive Depth First Search (DFS) to perform preorder traversal.

- In preorder traversal, visit nodes in the order:
    Root -> Left -> Right
- If the current node is null, return.
- Add the current node's value to the result.
- Recursively traverse the left subtree.
- Recursively traverse the right subtree.

Technique:
Tree DFS (Recursive Preorder Traversal)

Time Complexity:
O(n)

Space Complexity:
O(n)
- O(n) for the result list.
- O(h) recursion stack, where h is the height of the tree.
*/

class Solution {
    public static void preOrder(TreeNode root, List<Integer> arr) {
        if (root == null) return;

        arr.add(root.val);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        preOrder(root, arr);
        return arr;
    }
}
```
