import java.util.*;
/*
 * 2411-smallest-subarrays-with-maximum-bitwise-or.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/14
 */
public class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] res = new int[nums.length];
        int[] bitIndex = new int[32];
        int highBit = 0;
        Arrays.fill(bitIndex, -1);
        for (int i = nums.length-1; i >= 0; i--) {
            int nn = nums[i];
            int j = 0;
            int maxDis = 1;
            while (nn > 0 || j <= highBit) {
                highBit = Math.max(highBit, j);
                if (nn % 2 == 0) {
                    if (bitIndex[j] > 0) {
                        maxDis = Math.max(maxDis, bitIndex[j]-i+1);
                    }
                } else {
                    bitIndex[j] = i;
                }
                nn >>= 1;
                j++;
            }
            res[i] = maxDis;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,3,2,2,1]
        System.out.println(Arrays.toString(
            s.smallestSubarrays(new int[]{1,0,2,1,3})
        ));
        // [2,1]
        System.out.println(Arrays.toString(
            s.smallestSubarrays(new int[]{1,2})
        ));
    }
}