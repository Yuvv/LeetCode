public class Solution {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}

class MyCircularDeque {

    private int[] queue;
    private int head;
    private int tail;
    private int count;

    public MyCircularDeque(int k) {
        queue = new int[k];
        head = 0;
        tail = 0;
        count = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + queue.length) % queue.length;
        queue[head] = value;
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % queue.length;
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % queue.length;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + queue.length) % queue.length;
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int pos = (tail - 1 + queue.length) % queue.length;
        return queue[pos];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}