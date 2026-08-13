```java
/*
Problem:
LeetCode 232 - Implement Queue using Stacks

Link:
https://leetcode.com/problems/implement-queue-using-stacks/

Approach:
Use two stacks to implement the FIFO behavior of a queue.

- During push:
    - Push the new element into s1.
- During pop:
    - Move all elements except the bottom element from s1 to s2.
    - The remaining element in s1 is the front element of the queue.
    - Remove it.
    - Move all elements back from s2 to s1.
- During peek:
    - Move all elements except the bottom element from s1 to s2.
    - Store the remaining element.
    - Push it back into s1.
    - Move all elements back from s2 to s1.
- During empty:
    - Check whether s1 is empty.

Technique:
Two Stacks

Time Complexity:
push()  -> O(1)
pop()   -> O(n)
peek()  -> O(n)
empty() -> O(1)

Space Complexity:
O(n)
*/

import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int val = s1.pop();

        while (s2.size() != 0) {
            s1.push(s2.pop());
        }

        return val;
    }
    
    public int peek() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int val = s1.pop();
        s1.push(val);

        while (s2.size() != 0) {
            s1.push(s2.pop());
        }

        return val;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
```
