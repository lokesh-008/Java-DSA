/*
Problem:
LeetCode 155 - Min Stack

Link:
https://leetcode.com/problems/min-stack/

Approach:
Use two stacks.

- The first stack stores all the elements.
- The second stack keeps track of the minimum element corresponding to each position.
- During push:
    - Push the value into the main stack.
    - Push the smaller of the current value and the previous minimum into the min stack.
- During pop:
    - Pop from both stacks.
- The top of the min stack always stores the minimum element in O(1) time.

Technique:
Two Stacks

Time Complexity:
push()   -> O(1)
pop()    -> O(1)
top()    -> O(1)
getMin() -> O(1)

Space Complexity: O(n)
*/

class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.size() == 0){
            st.push(val);
            min.push(val);
        } else{
            st.push(val);
            if(min.peek() < val) min.push(min.peek());
            else min.push(val);
        }
        
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
