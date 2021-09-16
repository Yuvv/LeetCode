/*
 * 0978-longest-turbulent-subarray.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/15
 */
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 1;
        int i = 0, j;
        // case-1
        for (j = 1; j < arr.length; j++) {
            if (j % 2 == 1 && arr[j] <= arr[j - 1]
                    || j % 2 == 0 && arr[j] >= arr[j - 1]) {
                maxLen = Math.max(maxLen, j - i);
                i = j;
            }
        }
        maxLen = Math.max(maxLen, j - i);
        // case-2
        i = 0;
        for (j = 1; j < arr.length; j++) {
            if (j % 2 == 0 && arr[j] <= arr[j - 1]
                    || j % 2 == 1 && arr[j] >= arr[j - 1]) {
                maxLen = Math.max(maxLen, j - i);
                i = j;
            }
        }
        maxLen = Math.max(maxLen, j - i);
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        // 2
        System.out.println(s.maxTurbulenceSize(new int[]{4,8,12,16}));
        // 1
        System.out.println(s.maxTurbulenceSize(new int[]{100}));
    }

}