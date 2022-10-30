/*
 * 2455-average-value-of-even-numbers-that-are-divisible-by-three.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/10/30
 */
public class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int n : nums) {
            if (n % 6 == 0 ) {
                sum += n;
                cnt++;
            }
        }
        if (cnt == 0) {
            return 0;
        }
        return sum / cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.averageValue(new int[] {
            1,3,6,10,12,15
        }));
    }
}