/**
 * 2843-count-symmetric-integers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/12
 */
public class Solution {
    // 1 <= low <= high <= 10000
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        while (low <= high) {
            if (low >= 1 && low < 10) {
                low++;
                continue;
            }
            if (low >= 100 && low < 1000) {
                low++;
                continue;
            }
            if (low >= 10 && low < 100) {
                int a = low / 10;
                int b = low % 10;
                if (a == b) {
                    cnt++;
                }
            } else if (low >= 1000 && low < 10000) {
                int a = low / 1000;
                int b = (low / 100) % 10;
                int c = (low / 10) % 10;
                int d = low % 10;
                if (a + b == c + d) {
                    cnt++;
                }
            }
            low++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.countSymmetricIntegers(1, 100));
        // 4
        System.out.println(s.countSymmetricIntegers(1200, 1230));
    }
}
