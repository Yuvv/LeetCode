import java.util.*;

/**
 * 3164-find-the-number-of-good-pairs-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/26
 */
public class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> num2cntMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            num2cntMap.put(nums2[i], num2cntMap.getOrDefault(nums2[i], 0) + 1);
        }
        int cnt = 0;
        for (int a : nums1) {
            if (a % k != 0) {
                continue;
            }
            a /= k;
            for (int b = 1; b <= (int)Math.sqrt(a); b++) {
                if (a % b != 0) {
                    continue;
                }
                cnt += num2cntMap.getOrDefault(b, 0);
                int c = a / b;
                if (c != b) {
                    cnt += num2cntMap.getOrDefault(c, 0);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.numberOfPairs(
            new int[]{1,3,4}, new int[]{1,3,4}, 1
        ));
        // 2
        System.out.println(s.numberOfPairs(
            new int[]{1,2,4,12}, new int[]{2,4}, 3
        ));
    }
}