/*
 * 1974-minimum-time-to-type-word-using-special-typewriter.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/16
 */
public class Solution {
    public int minTimeToType(String word) {
        int cnt = 0;
        char lastCh = 'a';
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cnt += Math.min((ch + 26 - lastCh) % 26, (lastCh + 26 - ch) % 26) + 1;
            lastCh = ch;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minTimeToType("abc"));
        // 7
        System.out.println(s.minTimeToType("bza"));
        // 34
        System.out.println(s.minTimeToType("zjpc"));
    }
}