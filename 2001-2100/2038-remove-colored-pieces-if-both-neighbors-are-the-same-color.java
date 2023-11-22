/**
 * 2038-remove-colored-pieces-if-both-neighbors-are-the-same-color
 *
 * @authro Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/22
 */
public class Solution {
    public boolean winnerOfGame(String colors) {
        int ac = 0;
        int bc = 0;
        int j = 0;
        for (int i = 1; i < colors.length(); i++) {
            char cj = colors.charAt(j);
            while (i < colors.length() && colors.charAt(i) == cj) {
                i++;
            }
            int len = i - j;
            if (len >= 3) {
                if (cj == 'A') {
                    ac += len - 2;
                } else {
                    bc += len - 2;
                }
            }
            j = i;
        }
        return ac > bc;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.winnerOfGame("AAABABB"));
        // false
        System.out.println(s.winnerOfGame("AA"));
        // false
        System.out.println(s.winnerOfGame("ABBBBBBBAAA"));
    }
}
