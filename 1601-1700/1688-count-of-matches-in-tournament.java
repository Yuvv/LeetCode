/**
 * 1688-count-of-matches-in-tournament
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/05
 */
public class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            count += n / 2;
            if (n % 2 == 1) {
                n += 1;
            }
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.numberOfMatches(7));
        // 13
        System.out.println(s.numberOfMatches(14));
    }
}
