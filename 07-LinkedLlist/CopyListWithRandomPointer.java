/*
Problem:
LeetCode 138 - Copy List with Random Pointer

Link:
https://leetcode.com/problems/copy-list-with-random-pointer/

Approach:
Deep Copy + Interweaving + Random Pointer Assignment

- Create a deep copy of the linked list (without random pointers).
- Insert copied nodes alternately with original nodes.
- Set random pointers of copied nodes using the interweaved structure.
- Separate the original and copied lists.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public Node deepCopy(Node head){
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while(t1!=null){
            Node temp = new Node(t1.val);
            t2.next = temp;
            t1 = t1.next;
            t2 = t2.next;
        }
        return head2;
    }

    public Node connectAlternatively(Node head, Node head2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node temp1 = head;
        Node temp2 = head2;
        while(temp1!=null && temp2 != null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        return head2;
    }

    public void split(Node head, Node head2){
        Node t1 = head;
        Node t2 = head2;
        while(t1!=null){
            t1.next = t2.next;
            t1 = t1.next;
            if(t1==null) break;
            t2.next = t1.next;
            t2 = t2.next;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        // Create deep copy without random connections
        Node head2 = deepCopy(head);

        // Join head and head2 alternatively
        connectAlternatively(head, head2);

        // Assign random pointers   
        Node t1 = head;
        Node t2 = head2;
        while(t1!=null){
            t2 = t1.next;
            if(t1.random != null) t2.random = t1.random.next;
            t1 = t1.next.next;
        }

        // Split the LinkedList  
        split(head, head2);

        return head2; 
    }
}
