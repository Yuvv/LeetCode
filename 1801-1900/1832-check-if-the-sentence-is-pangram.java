/*
 * 1832-check-if-the-sentence-is-pangram.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/13
 */
public class Solution {
    public boolean checkIfPangram(String sentence) {
        int val = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            val |= 1 << (ch - 'a');
        }
        return val == 67108863;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        // false
        System.out.println(s.checkIfPangram("leetcode"));
    }
}