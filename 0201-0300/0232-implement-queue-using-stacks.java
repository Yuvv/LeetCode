import java.util.LinkedList;

/*
 * 0232-implement-queue-using-stacks.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/24
 */
public class MyQueue {

    private LinkedList<Integer> s1;
    private LinkedList<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        Integer result = s1.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        Integer result = s1.pop();
        s1.push(result);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */