import java.util.*;

/**
 * 3085-minimum-deletions-to-make-string-k-special.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/24
 */
public class Solution {
    public int minimumDeletions(String word, int k) {
        int[] cntarr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            cntarr[word.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cntarr.length; i++) {
            if (cntarr[i] == 0) {
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < cntarr.length; j++) {
                if (cntarr[j] == 0) {
                    continue;
                }
                if (cntarr[j] < cntarr[i]) {
                    cnt += cntarr[j];
                } else if (cntarr[j] > cntarr[i] + k) {
                    cnt += cntarr[j] - cntarr[i] - k;
                }
            }
            min = Math.min(min, cnt);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimumDeletions("aabcaba", 0));
        // 2
        System.out.println(s.minimumDeletions("dabdcbdcdcd", 2));
        // 1
        System.out.println(s.minimumDeletions("aaabaaa", 2));
    }
}
