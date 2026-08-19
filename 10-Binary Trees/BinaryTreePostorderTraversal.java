```java
/*
Problem:
LeetCode 145 - Binary Tree Postorder Traversal

Link:
https://leetcode.com/problems/binary-tree-postorder-traversal/

Approach:
Use recursive Depth First Search (DFS) to perform postorder traversal.

- In postorder traversal, visit nodes in the order:
    Left -> Right -> Root
- If the current node is null, return.
- Recursively traverse the left subtree.
- Recursively traverse the right subtree.
- Add the current node's value to the result after both subtrees
  have been processed.

Technique:
Tree DFS (Recursive Postorder Traversal)

Time Complexity:
O(n)

Space Complexity:
O(n)
- O(n) for the result list.
- O(h) recursion stack, where h is the height of the tree.
*/

class Solution {
    public static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }
}
```
