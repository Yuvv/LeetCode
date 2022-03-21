/*
 * 1929-concatenation-of-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/21
 */
public class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,1,1,2,1]
        System.out.println(s.getConcatenation(new int[] {1,2,1}));
    }
}