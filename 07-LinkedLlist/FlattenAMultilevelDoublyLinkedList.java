/*
Problem:
LeetCode 430 - Flatten a Multilevel Doubly Linked List

Link:
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

Approach:
Recursion + DFS Traversal

- Traverse the current level.
- If a node has a child:
    - Recursively flatten the child list.
    - Find the tail of the flattened child.
    - Insert the child list between the current node and its next node.
    - Update prev and next pointers.
    - Remove the child pointer.
- Continue traversing the original next node.

Time Complexity: O(n²) (due to repeatedly finding the child list tail)
Space Complexity: O(h) (recursion stack)
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp!=null){
            Node n = temp.next;
            if(temp.child != null){
                Node c = flatten(temp.child);
                Node d = c;
                while(d.next!=null) d = d.next;
                temp.next = c; c.prev = temp;
                d.next = n; 
                if(n!=null) n.prev = d;
                temp.child = null;
            }
            temp = n;
        }
        return head;

    }
}
