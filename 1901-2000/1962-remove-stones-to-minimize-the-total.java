import java.util.PriorityQueue;
import java.util.Comparator;


/*
 * 1962-remove-stones-to-minimize-the-total.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/07
 */
public class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int p : piles) {
            heap.add(p);
        }
        while (k > 0) {
            int p = heap.poll();
            p -= p / 2;
            heap.add(p);
            k--;
        }
        return heap.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.minStoneSum(new int[] {5,4,9}, 2));
        // 12
        System.out.println(s.minStoneSum(new int[] {4,3,6,7}, 3));
    }
}