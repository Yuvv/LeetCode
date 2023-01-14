/*
 * 1061-lexicographically-smallest-equivalent-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/14
 */
public class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] dsu = new int[26];
        java.util.Arrays.fill(dsu, -1);

        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            if (dsu[a] < 0) {
                dsu[a] = a;
            }
            if (dsu[b] < 0) {
                dsu[b] = b;
            }
            if (dsu[a] != dsu[b]) {
                int min = Math.min(dsu[a], dsu[b]);
                int max = Math.max(dsu[a], dsu[b]);
                for (int j = 0; j < 26; j++) {
                    if (dsu[j] == max) {
                        dsu[j] = min;
                    }
                }
            }
        }

        char[] res = new char[baseStr.length()];
        for (int i = 0; i < baseStr.length(); i++) {
            int x = dsu[baseStr.charAt(i) - 'a'];
            if (x >= 0) {
                res[i] = (char)('a' + x);
            } else {
                res[i] = baseStr.charAt(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "makkek"
        System.out.println(s.smallestEquivalentString(
            "parker",
            "morris",
            "parser"
        ));
        // "aauaaaaada"
        System.out.println(s.smallestEquivalentString(
            "leetcode",
            "programs",
            "sourcecode"
        ));
    }
}