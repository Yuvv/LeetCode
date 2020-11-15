import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/*
 * 1535-find-the-winner-of-an-array-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/11/15
 */
class Solution {
    public int getWinner(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxVal = arr[0];
        for (int a : arr) {
            list.add(a);
            maxVal = Math.max(a, maxVal);
        }
        if (k >= arr.length) {
            return maxVal;
        }
        while (true) {
            int a = list.pollFirst();
            int b = list.pollFirst();
            if (a > b) {
                list.addFirst(a);
                list.addLast(b);
            } else {
                list.addFirst(b);
                list.addLast(a);
            }
            int count = countMap.getOrDefault(list.peekFirst(), 0);
            count++;
            if (count >= k) {
                return list.peekFirst();
            }
            countMap.put(list.peekFirst(), count);
        }
        // return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 5 expected
        System.out.println(s.getWinner(new int[]{2,1,3,5,4,6,7}, 2));
        // 3 expected
        System.out.println(s.getWinner(new int[]{1,2,3}, 10));
        // 99 expected
        System.out.println(s.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000));
    }
}