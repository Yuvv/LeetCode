/*
 * 0556-next-greater-element-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/14
 */
public class Solution {
    public int nextGreaterElement(int n) {
        String str = "" + n;
        // find first decrement position
        int decPos = -1;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) < str.charAt(i+1)) {
                decPos = i;
                break;
            }
        }
        if (decPos < 0) {
            return -1;
        }
        // find smallest element that greater than decPosValue from decPos
        int gtPos = decPos + 1;
        for (int i = decPos + 2; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(decPos)) {
                gtPos = i;
            }
        }
        // swap
        char[] chArr = str.toCharArray();
        char tmp = chArr[decPos];
        chArr[decPos] = chArr[gtPos];
        chArr[gtPos] = tmp;
        // sort last
        java.util.Arrays.sort(chArr, decPos+1, chArr.length);
        // finally
        long val = Long.parseLong(new String(chArr));
        if (val > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Integer.MAX_VALUE);
        // 21
        System.out.println(s.nextGreaterElement(12));
        // -1
        System.out.println(s.nextGreaterElement(21));
    }
}