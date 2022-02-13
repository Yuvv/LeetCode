import java.util.PriorityQueue;
/*
 * 0135-candy.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/13
 */
public class Solution {
    public int candy(int[] ratings) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(ratings[a], ratings[b]));
        for (int i = 0; i < ratings.length; i++) {
            queue.add(i);
        }
        int sum = 0;
        int[] candy = new int[ratings.length];
        while (!queue.isEmpty()) {
            int i = queue.poll();
            candy[i] = 1;
            if (i > 0 && ratings[i] > ratings[i - 1]
                    && candy[i - 1] > 0 && candy[i] <= candy[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]
                    && candy[i + 1] > 0 && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.candy(new int[] {1, 0, 2}));
        // 4
        System.out.println(s.candy(new int[] {1,2,2}));
        // 24
        System.out.println(s.candy(new int[] {0,0,0,1,0,2,1,2,0,3,2,1,2,1,1,0}));
        // 28
        System.out.println(s.candy(new int[] {1,0,0,0,1,0,2,1,2,0,3,2,1,2,1,1,0,2}));
        // 30
        System.out.println(s.candy(new int[] {1,0,0,0,1,2,2,1,2,0,3,2,1,2,1,1,0,2}));
    }
}