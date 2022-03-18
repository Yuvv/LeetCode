/*
 * 1796-second-largest-digit-in-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/18
 */
public class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            if (val >= 0 && val <= 9) {
                if (val > first) {
                    second = first;
                    first = val;
                } else if (val < first && val > second) {
                    second = val;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.secondHighest("dfa12321afd"));
        // -1
        System.out.println(s.secondHighest("abc1111"));
    }
}