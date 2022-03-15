/*
 * 2119-a-number-after-a-double-reversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/15
 */
public class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }
}