/*
Problem:
LeetCode 725 - Split Linked List in Parts

Link:
https://leetcode.com/problems/split-linked-list-in-parts/

Approach:
Length Calculation + Equal Distribution

- Find the total length of the linked list.
- Compute:
    baseSize = length / k
    extra = length % k
- The first 'extra' parts contain one additional node.
- Disconnect each part and store its head.

Time Complexity: O(n + k)
Space Complexity: O(k)
*/

class Solution {
    public int lengthOfList(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = lengthOfList(head);
        int size = n / k;
        int extra = n % k;
        ListNode[] arr = new ListNode[k];
        int idx = 0;
        ListNode temp = head;
        int len = 1;
        while(temp!=null){
            int s = size;
            if(extra>0) s++;
            if(len==1) arr[idx++] = temp;
            if(len==s){
                ListNode a = temp.next;
                temp.next = null;
                temp = a;
                len = 1;
                extra--;
            } else{
                len++;
                temp = temp.next;
            }
        }
        return arr;
    }
}
