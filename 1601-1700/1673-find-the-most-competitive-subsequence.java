import java.util.*;

/*
 * 1673-find-the-most-competitive-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/03
 */
public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty()
                    && num < stack.peek()
                    && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,6]
        System.out.println(Arrays.toString(s.mostCompetitive(new int[] {3,5,2,6}, 2)));
        // [2,3,3,4]
        System.out.println(Arrays.toString(s.mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 4)));
        // [2,3,3,4]
        System.out.println(Arrays.toString(s.mostCompetitive(new int[] {71,18,52,29,55,73,24,42,66,8,80,2}, 3)));
    }

}