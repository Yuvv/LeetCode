/**
 * 2566-maximum-difference-by-remapping-a-digit.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/14
 */
public class Solution {
    public int minMaxDifference(int num) {
        int[] digits = new int[10];
        int i = 0;
        int lastNon9 = 0;
        while (num > 0) {
            int x = num % 10;
            digits[i++] = x;
            num /= 10;
            if (x != 9) {
                lastNon9 = x;
            }
        }
        int max = 0;
        for (int j = i-1; j >= 0; j--) {
            if (digits[j] == lastNon9) {
                max = max * 10 + 9;
            } else {
                max = max * 10 + digits[j];
            }
        }
        int first = digits[i - 1];
        int min = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (digits[j] == first) {
                min = min * 10 + 0;
            } else {
                min = min * 10 + digits[j];
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 99009
        System.out.println(s.minMaxDifference(11891));
        // 99
        System.out.println(s.minMaxDifference(90));
    }
}