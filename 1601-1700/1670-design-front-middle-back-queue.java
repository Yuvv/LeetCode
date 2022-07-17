import java.util.*;

/*
 * 1670-design-front-middle-back-queue.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/17
 */
public class FrontMiddleBackQueue {

    private LinkedList<Integer> frontQueue;
    private LinkedList<Integer> backQueue;

    public FrontMiddleBackQueue() {
        this.frontQueue = new LinkedList<>();
        this.backQueue = new LinkedList<>();
    }

    // make sure 0 <= (backQuque.size - frontQueue.size) <= 1
    private void reArrange() {
        while (frontQueue.size() - backQueue.size() > 0) {
            backQueue.addFirst(frontQueue.removeLast());
        }
        while (backQueue.size() - frontQueue.size() > 1) {
            frontQueue.addLast(backQueue.removeFirst());
        }
    }

    private boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }

    public void pushFront(int val) {
        frontQueue.addFirst(val);
        // re
        reArrange();
    }

    public void pushMiddle(int val) {
        frontQueue.addLast(val);
        // re
        reArrange();
    }

    public void pushBack(int val) {
        backQueue.addLast(val);
        // re
        reArrange();
    }

    public int popFront() {
        if (this.isEmpty()) {
            return -1;
        }
        int toPop;
        if (!frontQueue.isEmpty()) {
            toPop = frontQueue.poll();
        } else {
            toPop = backQueue.poll();
        }
        // re
        reArrange();

        return toPop;
    }

    public int popMiddle() {
        if (this.isEmpty()) {
            return -1;
        }
        int toPop;
        if (frontQueue.size() == backQueue.size()) {
            toPop = frontQueue.removeLast();
        } else {
            toPop = backQueue.removeFirst();
        }
        // re
        reArrange();

        return toPop;
    }

    public int popBack() {
        if (this.isEmpty()) {
            return -1;
        }
        int toPop = backQueue.removeLast();;
        // re
        reArrange();

        return toPop;
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        q.popFront();     // return 1 -> [4, 3, 2]
        q.popMiddle();    // return 3 -> [4, 2]
        q.popMiddle();    // return 4 -> [2]
        q.popBack();      // return 2 -> []
        q.popFront();     // return -1 -> [] (The queue is empty)
    }
}