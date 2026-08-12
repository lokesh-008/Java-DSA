```java
/*
Problem:
LeetCode 225 - Implement Stack using Queues

Link:
https://leetcode.com/problems/implement-stack-using-queues/

Approach:
Use a single queue to implement the LIFO behavior of a stack.

- During push:
    - Add the new element to the rear of the queue.
- During pop:
    - Move the first n-1 elements from the front to the rear.
    - The remaining element is the most recently added element.
    - Remove and return it.
- During top:
    - Move the first n-1 elements from the front to the rear.
    - The remaining element is the top of the stack.
    - Store its value, move it back to the rear, and return it.
- During empty:
    - Check whether the queue is empty.

Technique:
Queue

Time Complexity:
push()  -> O(1)
pop()   -> O(n)
top()   -> O(n)
empty() -> O(1)

Space Complexity:
O(n)
*/

import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }

        int val = q.remove();
        return val;
    }
    
    public int top() {
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }

        int peek = q.peek();
        q.add(q.remove());

        return peek;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
```
