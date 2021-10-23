/*
 * 0553-optimal-division.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/23
 */
public class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append('/').append('(').append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append('/').append(nums[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "1000/(100/10/2)"
        System.out.println(s.optimalDivision(new int[] {1000,100,10,2}));
        // "2/(3/4)"
        System.out.println(s.optimalDivision(new int[] {2,3,4}));
        // "2"
        System.out.println(s.optimalDivision(new int[] {2}));
    }
}