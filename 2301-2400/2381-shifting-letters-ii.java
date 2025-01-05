/**
 * 2381-shifting-letters-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/01/05
 */
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                arr[shift[0]]++;
                if (shift[1] < s.length() - 1) {
                    arr[shift[1] + 1]--;
                }
            } else {
                arr[shift[0]]--;
                if (shift[1] < s.length() - 1) {
                    arr[shift[1] + 1]++;
                }
            }
        }
        char[] chs = s.toCharArray();
        int x = 0;
        for (int i = 0; i < chs.length; i++) {
            x += arr[i];
            if (x != 0) {
                int y = (chs[i] - 'a' + x) % 26;
                if (y < 0) {
                    y += 26;
                }
                chs[i] = (char) ('a' + y);

            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "ace"
        System.out.println(s.shiftingLetters(
            "abc",
            new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}
        ));
        // "catz"
        System.out.println(s.shiftingLetters(
            "dztz",
            new int[][]{{0, 0, 0}, {1, 1, 1}}
        ));
    }
}
