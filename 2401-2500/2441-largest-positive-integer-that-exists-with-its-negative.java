import java.util.*;

/*
 * 2441-largest-positive-integer-that-exists-with-its-negative.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/15
 */
public class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;
        for (int n : nums) {
            if (n < 0) {
                set.add(n);
            }
        }
        for (int n : nums) {
            if (n > 0) {
                if (set.contains(-n) && n > res) {
                    res = n;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findMaxK(
            new int[] {-1,2,-3,3}
        ));
    }
}