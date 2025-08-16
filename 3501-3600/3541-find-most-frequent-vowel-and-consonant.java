/**
 * 3541-find-most-frequent-vowel-and-consonant.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/16
 */
public class Solution {
    public int maxFreqSum(String s) {
        int[] cntarr = new int[26];
        int maxv = 0;
        int maxc = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            cntarr[idx]++;
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (cntarr[idx] > maxv) {
                    maxv = cntarr[idx];
                }
            } else {
                maxc = Math.max(maxc, cntarr[idx]);
            }
        }
        return maxc+maxv;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.maxFreqSum("successes"));
        // 3
        System.out.println(s.maxFreqSum("aeiaeia"));
    }
}