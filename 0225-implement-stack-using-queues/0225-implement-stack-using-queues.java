import java.util.*;

class MyStack {
    private Queue<Integer> q1; // holds elements in "stack order" (front = top)
    private Queue<Integer> q2; // temporary helper queue

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        // 1. put new element into empty q2

         while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        q1.offer(x);

        // 2. drain q1 into q2, placing old elements behind the new one
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }

   
    }

    public int pop() {
        return q1.poll(); // front is always the most recently pushed
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}