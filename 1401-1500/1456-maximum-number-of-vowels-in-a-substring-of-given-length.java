/*
 * 1456-maximum-number-of-vowels-in-a-substring-of-given-length.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/04
 */
public class Solution {
    public boolean isVowel(char ch) {
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

    public int maxVowels(String s, int k) {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
            }
        }
        if (cnt == k) {
            // fast success
            return cnt;
        }

        int max = cnt;
        for (int j = k; j < s.length(); j++) {
            if (isVowel(s.charAt(j))) {
                cnt++;
            }
            if (isVowel(s.charAt(j-k))) {
                cnt--;
            }
            max = Math.max(max, cnt);
            if (max == k) {
                // fast success
                return cnt;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxVowels("abciiidef", 3));
        // 2
        System.out.println(s.maxVowels("aeiou", 2));
        // 2
        System.out.println(s.maxVowels("leetcode", 3));
    }
}