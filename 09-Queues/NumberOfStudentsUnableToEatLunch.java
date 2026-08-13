```java
/*
Problem:
LeetCode 1700 - Number of Students Unable to Eat Lunch

Link:
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

Approach:
Use a Queue for students and a Stack for sandwiches.

- Store the sandwiches in a stack so that the top represents the
  sandwich currently available.
- Store all students in a queue in their original order.
- For every student:
    - If the student's preference matches the top sandwich:
        - Remove the student from the queue.
        - Remove the sandwich from the stack.
    - Otherwise:
        - Remove the student from the front.
        - Add the student to the rear of the queue.
- Continue the process for at most n² operations.
- If the queue becomes empty, all students have been served.
- Otherwise, the remaining queue size represents the number of
  students unable to eat lunch.

Technique:
Queue + Stack

Time Complexity:
O(n²)

Space Complexity:
O(n)
*/

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int countStudents(int[] arr1, int[] arr2) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        int n = arr1.length;

        for (int i = n - 1; i >= 0; i--) {
            st.push(arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            q.add(arr1[i]);
        }

        for (int i = 0; i < n * n; i++) {
            if (q.size() == 0) {
                return 0;
            }

            if (q.peek() == st.peek()) {
                q.remove();
                st.pop();
            } else {
                q.add(q.remove());
            }
        }

        return q.size();
    }
}
```
