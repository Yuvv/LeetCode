/*
 * 1138-alphabet-board-path.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/22
 */
public class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int r = 0, c = 0;
        for (int i = 0; i < target.length(); i++) {
            int chVal = target.charAt(i) - 'a';
            int targetY = chVal / 5;
            int targetX = chVal % 5;
            while (targetX != c || targetY != r) {
                while (c > targetX) {
                    sb.append('L');
                    c--;
                }
                while (c < targetX && r < 5) {
                    sb.append('R');
                    c++;
                }
                while (r > targetY) {
                    sb.append('U');
                    r--;
                }
                while (r < targetY && (r < 4 || c == 0)) {
                    sb.append('D');
                    r++;
                }
            }
            sb.append('!');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "DDR!UURRR!!DDD!"
        System.out.println(s.alphabetBoardPath("leet"));
        // "RR!DDRR!UUL!R!"
        System.out.println(s.alphabetBoardPath("code"));
        // "DDDDD!UUUUUR!"
        System.out.println(s.alphabetBoardPath("zb"));  // --> be careful of not existed position
    }
}