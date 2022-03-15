/*
 * 2185-counting-words-with-a-given-prefix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/15
 */
public class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}