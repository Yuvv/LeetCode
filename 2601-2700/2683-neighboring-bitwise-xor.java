/**
 * 2683-neighboring-bitwise-xor.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/29
 */
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        // if origin[0] = 0
        int x = 0;
        for (int i = 0; i < derived.length; i++) {
            if (x == 0) {
                x ^= derived[i];
            } else {
                x = 1 - derived[i];
            }
        }
        if (x == 0) {
            return true;
        }
        // if origin[0] = 1
        x = 1;
        for (int i = 0; i < derived.length; i++) {
            if (x == 0) {
                x ^= derived[i];
            } else {
                x = 1 - derived[i];
            }
        }
        return x == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.doesValidArrayExist(new int[]{1,1,0}));
        // true
        System.out.println(s.doesValidArrayExist(new int[]{1,1}));
        // false
        System.out.println(s.doesValidArrayExist(new int[]{1,0}));
    }
}
