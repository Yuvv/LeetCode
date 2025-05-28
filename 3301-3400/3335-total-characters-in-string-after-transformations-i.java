/**
 * 3335-total-characters-in-string-after-transformations-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/18
 */
public class Solution {

    public int lengthAfterTransformations(String s, int t) {
        long[] arr = new long[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        long res = s.length();
        int zIdx = 25;
        while (t > 0) {
            t--;
            res += arr[zIdx];
            res %= 1000000007L;
            int aIdx = (zIdx+1)%26;
            arr[aIdx] += arr[zIdx];
            arr[aIdx] %= 1000000007L;
            zIdx = (zIdx+25)%26;  // move to next zIndex
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.lengthAfterTransformations("abcyy", 2));
        // 5
        System.out.println(s.lengthAfterTransformations("azbk", 1));
        // 479641805
        System.out.println(s.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 99999));
    }
}