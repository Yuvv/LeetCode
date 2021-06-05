/*
 * 0151-reverse-words-in-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/05
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chs = s.trim().trim().toCharArray();
        int i = 0, j = chs.length - 1;
        char tmp;
        // reverse chs
        while (i < j) {
            tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }

        // reverse each word
        i = 0;
        int insertPos = 0;
        while (i < chs.length) {
            // find word begin_i & end_j
            while (i < chs.length && chs[i] == ' ') {
                i++;
            }
            if (i >= chs.length) {
                break;
            }
            j = i + 1;
            while (j < chs.length && chs[j] != ' ') {
                j++;
            }
            // insert a space if needed
            if (insertPos > 0) {
                chs[insertPos] = ' ';
                insertPos++;
            }
            // reverse word and place each character in right place
            for (int k = j - 1; k >= i; k--) {
                if (insertPos < i) {
                    chs[insertPos] = chs[k];
                    chs[k] = ' ';
                } else {
                    tmp = chs[i];
                    chs[i] = chs[k];
                    chs[k] = tmp;
                    i++;
                }
                insertPos++;
            }
            while (insertPos < chs.length && chs[insertPos] != ' ') {
                insertPos++;
            }
            i = j + 1;
        }

        return new String(chs, 0, insertPos);
    }


    public static void main(String[] s) {
        Solution s = new Solution();

        // "blue is sky the"
        System.out.println(s.reverseWords("the sky is blue"));
        // "world hello"
        System.out.println(s.reverseWords("  hello world  "));
        // "example good a"
        System.out.println(s.reverseWords("a good   example"));
        // "Alice Loves Bob"
        System.out.println(s.reverseWords("  Bob    Loves  Alice   "));
    }
}