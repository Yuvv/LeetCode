/*
 * 2255-count-prefixes-of-a-given-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/12
 */
public class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.countPrefixes(new String[] {"a", "b", "c", "ab", "bc", "abc"}, "abc"));
        // 2
        System.out.println(s.countPrefixes(new String[] {"a", "a"}, "aa"));
    }
}