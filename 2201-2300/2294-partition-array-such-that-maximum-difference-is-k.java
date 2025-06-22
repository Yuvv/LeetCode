import java.util.Arrays;
/**
 * 2294-partition-array-such-that-maximum-difference-is-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/22
 */
public class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] - nums[i] > k) {
                cnt++;
                i = j;
            }
        }
        if (i < nums.length) {
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.partitionArray(new int[]{1, 3, 6, 2, 5}, 2));
        // 2
        System.out.println(s.partitionArray(new int[]{1,2,3}, 1));
        // 3
        System.out.println(s.partitionArray(new int[]{2,2,4,5}, 0));
    }
}