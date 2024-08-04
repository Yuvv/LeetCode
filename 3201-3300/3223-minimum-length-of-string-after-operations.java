/**
 * 3223-minimum-length-of-string-after-operations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/04
 */
public class Solution {
    public int minimumLength(String s) {
        int[] cntarr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cntarr[s.charAt(i)-'a']++;
        }
        int res = 0;
        for (int n : cntarr) {
            if (n > 0) {
                if (n % 2 == 0) {
                    res += 2;
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minimumLength("abaacbcbb"));
        // 2
        System.out.println(s.minimumLength("aa"));
    }
}
