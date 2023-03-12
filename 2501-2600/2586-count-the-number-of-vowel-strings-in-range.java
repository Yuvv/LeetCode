/*
 * 2586-count-the-number-of-vowel-strings-in-range.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/03/12
 */

public class Solution {
    private boolean isVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            char ch0 = words[i].charAt(0);
            char ch$ = words[i].charAt(words[i].length()-1);
            if (isVowel(ch0) && isVowel(ch$)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.vowelStrings(
            new String[] {"are", "amy", "u"},
            0, 2
        ));
        // 3
        System.out.println(s.vowelStrings(
            new String[] {"hey","aeo","mu","ooo","artro"},
            1, 4
        ));
    }
}
