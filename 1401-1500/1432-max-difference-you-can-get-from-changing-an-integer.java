/**
 * 1432-max-difference-you-can-get-from-changing-an-integer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/15
 */
public class Solution {
    public int maxDiff(int num) {
        int[] digits = new int[10];
        int i = 0;
        int lastNon9 = 0;
        int lastNon0 = 0;
        while (num > 0) {
            int x = num % 10;
            digits[i++] = x;
            num /= 10;
            if (x != 9) {
                lastNon9 = x;
            }
            if (x != 0) {
                lastNon0 = x;
            }
        }
        int max = 0;
        int min = 0;
        int minReplace = 0;
        if (lastNon0 == digits[i-1]) {
            if (lastNon0 == 1) {
                lastNon0 = -1;
                for (int j = i-1; j >= 0; j--) {
                    if (digits[j] > 1) {
                        lastNon0 = digits[j];
                        break;
                    }
                }
            } else {
                minReplace = 1;  // replace with 1
            }
        }
        for (int j = i-1; j >= 0; j--) {
            if (digits[j] == lastNon9) {
                max = max * 10 + 9;  // replace with 9
            } else {
                max = max * 10 + digits[j];
            }
            if (digits[j] == lastNon0) {
                min = min * 10 + minReplace;  // replace with MinReplace
            } else {
                min = min * 10 + digits[j];
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 888
        System.out.println(s.maxDiff(555));
        // 8
        System.out.println(s.maxDiff(8));
        // 85800000
        System.out.println(s.maxDiff(15143234));
        // 8808050
        System.out.println(s.maxDiff(1101057));
    }
}