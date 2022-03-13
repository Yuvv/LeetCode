import java.util.PriorityQueue;
/*
 * 1705-maximum-number-of-eaten-apples.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/16
 */
public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            // sort by rot day
            return Integer.compare(a[0], b[0]);
        });

        int cnt = 0;
        // eat one apple every day. (be careful of the `!queue.isEmpty()` for the lasting days)
        for (int i = 0; i < apples.length || !queue.isEmpty(); i++) {
            if (i < apples.length && days[i] > 0 && apples[i] > 0) {
                queue.add(new int[] {i + days[i] - 1, apples[i]});
            }
            while (!queue.isEmpty()) {
                int[] arr = queue.peek();
                if (arr[0] >= i && arr[1] > 0) {
                    break;
                }
                queue.poll();
            }
            if (!queue.isEmpty()) {
                int[] arr = queue.peek();
                arr[1]--;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.eatenApples(new int[] {1,2,3,5,2}, new int[] {3,2,1,4,2}));
        // 5
        System.out.println(s.eatenApples(new int[] {3,0,0,0,0,2}, new int[] {3,0,0,0,0,2}));
        // 4
        System.out.println(s.eatenApples(new int[] {2,1,10}, new int[] {2,10,1}));
    }
}