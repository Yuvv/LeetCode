import java.util.*;

/*
 * 2200-find-all-k-distant-indices-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/13
 */
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int lastEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int beg = Math.max(lastEnd + 1, i - k);
                int end = Math.min(nums.length - 1, i + k);
                while (beg <= end) {
                    res.add(beg++);
                }
                lastEnd = end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,4,5,6]
        System.out.println(s.findKDistantIndices(
            new int[] {3,4,9,1,3,9,5},
            9, 1
        ));
        // [0,1,2,3,4]
        System.out.println(s.findKDistantIndices(
            new int[] {2,2,2,2,2},
            2, 2
        ));
    }
}