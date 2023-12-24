/**
 * 1758-minimum-changes-to-make-alternating-binary-string
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/24
 */
public class Solution {
    public int minOperations(String s) {
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) {
                if (ch == '0') {
                    cnt1++;
                } else {
                    cnt0++;
                }
            } else {
                if (ch == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }
        return Math.min(cnt0, cnt1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minOperations("0100"));
        // 0
        System.out.println(s.minOperations("10"));
        // 2
        System.out.println(s.minOperations("1111"));
    }
}
