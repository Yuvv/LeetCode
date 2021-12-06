import java.util.Arrays;

/*
 * 1769-minimum-number-of-operations-to-move-all-balls-to-each-box.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/06
 */
public class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        int leftSum = 0;
        int leftCnt = 0;
        int rightSum = 0;
        int rightCnt = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                rightSum += i;
                rightCnt++;
            }
        }

        res[0] = leftSum + rightSum;
        for (int i = 1; i < boxes.length(); i++) {
            // right need count down
            rightSum -= rightCnt;
            if (boxes.charAt(i) == '1') {
                rightCnt--;
            }
            // left need count up
            if (boxes.charAt(i - 1) == '1') {
                leftCnt++;
            }
            leftSum += leftCnt;

            res[i] = leftSum + rightSum;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,1,3]
        System.out.println(Arrays.toString(s.minOperations("110")));
        // [11,8,5,4,3,4]
        System.out.println(Arrays.toString(s.minOperations("001011")));
    }
}