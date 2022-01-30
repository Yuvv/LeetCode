
public class Solution {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }
}

/*
 * 0622-design-circular-queue.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/30
 */
class MyCircularQueue {

    private int[] queue;
    private int tail;
    private int head;
    private int count;

    public MyCircularQueue(int k) {
        queue = new int[k];
        tail = 0;
        head = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        count++;
        tail++;
        tail %= queue.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        count--;
        head++;
        head %= queue.length;
        return true;
    }

    public int Front() {
        if (count == 0) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        }
        int pos = (tail + queue.length - 1) % queue.length;
        return queue[pos];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}
