import java.util.*;

/**[
 * 0950-reveal-cards-in-increasing-order.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/04/10
 */
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int d : deck) {
            pq.add(d);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            if (queue.size() > 1) {
                queue.addFirst(queue.pollLast());
            }
            queue.addFirst(pq.poll());
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = queue.pollFirst();
        }
        return deck;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,13,3,11,5,17,7]
        System.out.println(s.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7}));
        // [1,1000]
        System.out.println(s.deckRevealedIncreasing(new int[]{1,1000}));
    }
}