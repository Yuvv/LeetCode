/**
 * 3271-hash-divided-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/03
 */
public class Solution {
    public String stringHash(String s, int k) {
        char[] res = new char[s.length()/k];
        for (int i = 0; i < s.length(); i += k) {
            int x = 0;
            for (int j = i; j < i+k; j++) {
                x += s.charAt(j) - 'a';
            }
            res[i/k] = (char)((x%26) + 'a');
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "bf"
        System.out.println(s.stringHash("abcd", 2));
        // "i"
        System.out.println(s.stringHash("mxz", 3));
    }
}
