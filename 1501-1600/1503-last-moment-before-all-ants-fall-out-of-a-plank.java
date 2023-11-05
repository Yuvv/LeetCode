import java.util.*;

/*
 * 1503-last-moment-before-all-ants-fall-out-of-a-plank.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/05
 */
public class Solution {
    public int getLastMoment_sort(int n, int[] left, int[] right) {
        Arrays.sort(left); // you don't need sort
        Arrays.sort(right); // you don't need sort
        if (left.length == 0) {
            return n - right[0];
        } else if (right.length == 0) {
            return left[left.length - 1];
        }
        return Math.max(n - right[0], left[left.length-1]);
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int pt : right) {
            max = Math.max(max, n - pt);
        }
        for (int pt : left) {
            max = Math.max(max, pt);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 100
        System.out.println(s.getLastMoment(
            100,
            new int[] {1, 4, 10, 16, 21, 39, 46, 49, 54, 56, 60, 62, 70, 71, 72, 79, 83, 84, 86, 88, 91},
            new int[] {0, 65, 98, 64, 37, 5, 7, 75, 76, 12, 47, 48, 82, 50, 53, 90, 27, 95}
        ));
    }
}