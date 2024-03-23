/**
 * 2516-take-k-of-each-character-from-left-and-right.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/23
 */
public class Solution {
    public int takeCharacters(String s, int k) {
        if (k*3 > s.length()) {
            return -1;
        }
        if (k == 0) {
            return 0;
        }
        int[] cntarr = new int[3];
        int i = 0;
        boolean find = false;
        while (i < s.length()) {
            int idx = s.charAt(i) - 'a';
            cntarr[idx]++;
            if (cntarr[0] >= k && cntarr[1] >= k && cntarr[2] >= k) {
                find = true;
                break;
            }
            i++;
        }
        if (!find) {
            return -1;
        }
        int minLen = i + 1;
        for (int j = s.length()-1; j >= 0; j--) {
            int idx = s.charAt(j) - 'a';
            cntarr[idx]++;
            while (i >= 0 && cntarr[0] >= k && cntarr[1] >= k && cntarr[2] >= k) {
                minLen = Math.min(minLen, i + 1 + s.length() - j);
                cntarr[s.charAt(i)-'a']--;
                i--;
            }
            if (i < 0 && cntarr[0] >= k && cntarr[1] >= k && cntarr[2] >= k) {
                minLen = Math.min(minLen, s.length() - j);
                break;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.takeCharacters("aabaaaacaabc", 2));
        // -1
        System.out.println(s.takeCharacters("a", 1));
    }
}