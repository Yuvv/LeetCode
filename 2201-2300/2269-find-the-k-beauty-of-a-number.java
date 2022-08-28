/*
 * 2269-find-the-k-beauty-of-a-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/28
 */
public class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = "" + num;
        int cnt = 0;
        for (int i = k; i <= numStr.length(); i++) {
            int val = Integer.parseInt(numStr.substring(i - k, i));
            if (val > 0 && num % val == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.divisorSubstrings(240, 2));
        // 2
        System.out.println(s.divisorSubstrings(430043, 2));
    }
}