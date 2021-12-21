/*
 * 0393-utf-8-validation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/21
 */
public class Solution {
    public boolean startsWith10(int n) {
        return ((n & 0xC0) ^ 0x80) == 0;
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int d = data[i];
            if ((d & 0x80) == 0) {
                // 1-byte
            } else if (((d & 0xE0) ^ 0xC0) == 0) {
                // 2-byte
                if (i >= data.length - 1) {
                    return false;
                }
                if (!startsWith10(data[++i])) {
                    return false;
                }
            } else if (((d & 0xF0) ^ 0xE0) == 0) {
                // 3-byte
                if (i >= data.length - 2) {
                    return false;
                }
                if (!startsWith10(data[++i]) || !startsWith10(data[++i])) {
                    return false;
                }
            } else if (((d & 0xF8) ^ 0xF0) == 0) {
                // 4-byte
                if (i >= data.length - 3) {
                    return false;
                }
                if (!startsWith10(data[++i]) || !startsWith10(data[++i]) || !startsWith10(data[++i])) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.validUtf8(new int[] {197,130,1}));
        // false
        System.out.println(s.validUtf8(new int[] {235,140,4}));
    }
}
