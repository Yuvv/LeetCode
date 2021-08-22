import java.util.*;

/*
 * 0703-kth-largest-element-in-a-stream.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/22
 */
public class KthLargest {

    private int maxSize;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.maxSize = k;
        this.heap = new PriorityQueue<>();
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < maxSize) {
            heap.add(val);
        } else if (heap.peek() < val) {
            heap.add(val);
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
