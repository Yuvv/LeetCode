import java.util.*;
/*
 * 1381-design-a-stack-with-increment-operation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/25
 */
public class CustomStack {

    private int[] stack;
    private int pos;
    private PriorityQueue<int[]> pq;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        pos = 0;
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
    }

    public void push(int x) {
        if (pos < stack.length) {
            stack[pos++] = x;
        }
    }

    public int pop() {
        if (pos == 0) {
            return -1;
        }
        pos--;
        int res = stack[pos];
        while (!pq.isEmpty() && pq.peek()[0] >= pos) {
            int[] oo = pq.poll();
            res += oo[1];
            oo[0]--;
            if (oo[0] >= 0) {
                pq.add(oo);
            }
        }
        return res;
    }

    public void increment(int k, int val) {
        k--;
        if (k >= pos) {
            k = pos - 1;
        }
        if (k >= 0) {
            pq.add(new int[] {k, val});
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }
}