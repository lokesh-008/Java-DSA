```java
/*
Problem:
LeetCode 94 - Binary Tree Inorder Traversal

Link:
https://leetcode.com/problems/binary-tree-inorder-traversal/

Approach:
Use recursive Depth First Search (DFS) to perform inorder traversal.

- In inorder traversal, visit nodes in the order:
    Left -> Root -> Right
- If the current node is null, return.
- Recursively traverse the left subtree.
- Add the current node's value to the result.
- Recursively traverse the right subtree.

Technique:
Tree DFS (Recursive Inorder Traversal)

Time Complexity:
O(n)

Space Complexity:
O(n)
- O(n) for the result list.
- O(h) recursion stack, where h is the height of the tree.
*/

class Solution {
    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
}
```
