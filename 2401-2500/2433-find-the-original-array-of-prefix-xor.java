/*
 * 2433-find-the-original-array-of-prefix-xor.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/05
 */
public class Solution {
    public int[] findArray(int[] pref) {
        int x = pref[0];
        int y;
        for (int i = 1; i < pref.length; i++) {
            y = x ^ pref[i];
            x = pref[i];
            pref[i] = y;
        }
        return pref;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,7,2,3,2]
        System.out.println(java.util.Arrays.toString(
            so.findArray(new int[] {5,2,0,3,1})
        ));
    }
}