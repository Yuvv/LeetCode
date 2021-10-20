import java.util.Map;
import java.util.HashMap;
/*
 * 1371-find-the-longest-substring-containing-vowels-in-even-counts.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/20
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int[] cumsum = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            cumsum[i] = cumsum[i - 1];
            switch (s.charAt(i - 1)) {
                case 'a':
                    cumsum[i] ^= 0x01;
                    break;
                case 'e':
                    cumsum[i] ^= 0x02;
                    break;
                case 'i':
                    cumsum[i] ^= 0x04;
                    break;
                case 'o':
                    cumsum[i] ^= 0x08;
                    break;
                case 'u':
                    cumsum[i] ^= 0x10;
                    break;
                default:
                    break;
            }
        }
        int maxLen = 0;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < cumsum.length; i++) {
            if (idxMap.containsKey(cumsum[i])) {
                Integer firstIdx = idxMap.get(cumsum[i]);
                maxLen = Math.max(maxLen, i - firstIdx);
            } else {
                idxMap.put(cumsum[i], i);
            }
        }

        return maxLen;
        // return getMaxLength(cumsum, 0, s.length());
    }

    public int getMaxLength(int[] cumsum, int beg, int end) {
        if (beg >= end) {
            return 0;
        }
        if (cumsum[end] == cumsum[beg]) {
            return end - beg;
        }

        int len1 = getMaxLength(cumsum, beg + 1, end);
        int len2 = getMaxLength(cumsum, beg, end - 1);
        return Math.max(len1, len2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.findTheLongestSubstring("eleetminicoworoep"));
        // 5
        System.out.println(s.findTheLongestSubstring("leetcodeisgreat"));
        // 6
        System.out.println(s.findTheLongestSubstring("bcbcbc"));
        // 53
        System.out.println(s.findTheLongestSubstring("bcbcbcleetcodeisgrleetcodeisgreatfjkhasdkfhdskjlafhaeateleetminicoworoep"));
    }
}