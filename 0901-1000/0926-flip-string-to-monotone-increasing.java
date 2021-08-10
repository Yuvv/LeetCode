
/*
 * 0926-flip-string-to-monotone-increasing.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/10
 */

public class Solution {
    private int[] gn;

    public int minFlipsMonoIncr(String s) {
        // f(1..n) => f(1)->0 + f(2..n)
        //            f(1)->1 + g(2..n)
        this.gn = new int[s.length()];
        int cum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cum += 1;
            }
            this.gn[i] = cum;
        }

        return this.minFlips(s, 0);
    }

    public int minFlips(String s, int fromIdx) {
        if (fromIdx >= s.length()) {
            return 0 ;
        }
        char c = s.charAt(fromIdx);
        int min0 = c - '0' + this.minFlips(s, fromIdx + 1);
        int min1 = '1' - c + this.gn[fromIdx];
        return Math.min(min0, min1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minFlipsMonoIncr("00110"));
        // 2
        System.out.println(s.minFlipsMonoIncr("010110"));
        // 2
        System.out.println(s.minFlipsMonoIncr("0100101101010100010101110"));
        // inputs
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + "->" + s.minFlipsMonoIncr(args[i]));
        }
    }
}