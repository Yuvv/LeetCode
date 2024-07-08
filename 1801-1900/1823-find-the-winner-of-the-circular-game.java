import java.util.*;

/**
 * 1823-find-the-winner-of-the-circular-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/08
 */
public class Solution {
    // https://en.wikipedia.org/wiki/Josephus_problem
    public int findTheWinner(int n, int k) {
        // g(n, k) = (g(n-1, k) + k) MOD n, g(1, k) = 0
        int gi = 0;
        for (int i = 2; i <= n; i++) {
            gi = (gi + k) % i;
        }
        return gi + 1;
    }
    // simulation, AC but slow
    public int findTheWinner_simulation(int n, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        while (n > 0) {
            queue.addFirst(n);
            n--;
        }
        int cnt = 0;
        while (queue.size() > 1) {
            cnt++;
            if (cnt % k == 0) {
                queue.pollFirst();
            } else {
                queue.addLast(queue.pollFirst());
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findTheWinner(5, 2));
        // 1
        System.out.println(s.findTheWinner(6, 5));
    }
}
