import java.util.*;

/**
 * 4065. Rearrange Array by Removing Distinct Values
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/10/7
 */
public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int n : nums) {
            cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
        }
        while (cntMap.size() > 0 ) {
            int ii = i;
            for (Integer k : cntMap.keySet()) {
                res[i++] = k;
            }
            for (int j = ii; j < i; j++) {
                int cnt = cntMap.get(res[j]);
                if (cnt == 1) {
                    cntMap.remove(res[j]);
                } else {
                    cntMap.put(res[j], cnt-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,1,3,3]
        System.out.println(s.rearrangeArray(new int[]{3,1,3,2,1,3}));
    }
}
