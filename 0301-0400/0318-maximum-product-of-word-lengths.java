/*
 * 0318-maximum-product-of-word-lengths.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/21
 */
public class Solution {
    static int[] LETTER_VAL = new int[26];
    static {
        LETTER_VAL[0] = 1;
        for (int i = 1; i <= 25; i++) {
            LETTER_VAL[i] = LETTER_VAL[i - 1] << 1;
        }
    }

    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int n = 0;
            for (int j = 0; j < w.length(); j++) {
                n |= LETTER_VAL[w.charAt(j) - 'a'];
            }
            nums[i] = n;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 16
        System.out.println(s.maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
        // 4
        System.out.println(s.maxProduct(new String[] {"a","ab","abc","d","cd","bcd","abcd"}));
        // 0
        System.out.println(s.maxProduct(new String[] {"a","aa","aaa","aaaa"}));
    }
}