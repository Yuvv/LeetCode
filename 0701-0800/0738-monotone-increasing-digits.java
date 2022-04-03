import java.util.*;

/*
 * 0738-monotone-increasing-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/03
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] nums = ("" + n).toCharArray();
        char lastCh = nums[nums.length - 1];
        int last9idx = nums.length;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > lastCh) {
                nums[i] = (char) (nums[i] - 1);
                for (int j = i + 1; j < last9idx; j++) {
                    nums[j] = '9';
                }
                last9idx = i + 1;
            }
            lastCh = nums[i];
        }
        return Integer.parseInt(new String(nums));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.monotoneIncreasingDigits(10));
        // 1234
        System.out.println(s.monotoneIncreasingDigits(1234));
        // 299
        System.out.println(s.monotoneIncreasingDigits(332));
        // 2349999
        System.out.println(s.monotoneIncreasingDigits(2354658));
        // 2349999
        System.out.println(s.monotoneIncreasingDigits(2354658));
        // 2349999
        System.out.println(s.monotoneIncreasingDigits(2354168));
    }
}
