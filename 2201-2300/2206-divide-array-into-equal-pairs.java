/**
 * 2206-divide-array-into-equal-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/13
 */
public class Solution {
    // 1 <= n <= 500
    // 1 <= nums[i] <= 500
    public boolean divideArray(int[] nums) {
        boolean[] visited = new boolean[501];
        for (int n : nums) {
            visited[n] = !visited[n];
        }
        for (boolean v : visited) {
            if (v) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        // false
        System.out.println(s.divideArray(new int[]{1, 2, 3, 4}));
    }
}
