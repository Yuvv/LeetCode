/**
 * 2264-largest-3-same-digit-number-in-string
 *
 * @authro Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/04
 */
public class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 0; i < num.length() - 2; i++) {
            char ch = num.charAt(i);
            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2)) {
                if (max.length() == 0 || max.charAt(0) < ch) {
                    max = num.substring(i, i + 3);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "777"
        System.out.println(s.largestGoodInteger("6777133339"));
        // "000"
        System.out.println(s.largestGoodInteger("2300019"));
        // ""
        System.out.println(s.largestGoodInteger("423525338"));
    }
}
