/*
 * 2678-number-of-senior-citizens.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/05/21
 */
public class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String ss : details) {
            char a = ss.charAt(11);
            if (a > '6') {
                cnt++;
            } else if (a == '6') {
                if (ss.charAt(12) > '0') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countSeniors(new String[] {
            "7868190130M7522","5303914400F9211","9273338290F4010"
        }));
        // 0
        System.out.println(s.countSeniors(new String[] {
            "1313579440F2036","2921522980M5644"
        }));
    }
}