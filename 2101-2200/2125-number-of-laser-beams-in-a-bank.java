/*
 * 2125-number-of-laser-beams-in-a-bank.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/21
 */
public class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int last = 0;
        for (String row : bank) {
            int cnt = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    cnt++;
                }
            }
            res += cnt * last;
            if (cnt > 0) {
                last = cnt;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.numberOfBeams(new String[] {
            "011001",
            "000000",
            "010100",
            "001000"
        }));
    }
}