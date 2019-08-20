import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 0055-jump-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/08/17
 */
class Solution {
    public boolean canJump(int[] nums) {
         if (nums.length <= 1) {
             return true;
         }
         int max = nums[0];
         int curMax;
         for (int i = 1; i <= max; i++) {
             curMax = nums[i] + i;
             if (curMax > max) {
                 max = curMax;
             }
             if (max >= nums.length - 1) {
                 return true;
             }
         }
         return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true  expected
        System.out.println(s.canJump(new int[] {2, 3, 1, 1, 4}));
        // false  expected
        System.out.println(s.canJump(new int[] {3, 2, 1, 0, 4}));
        // true  expected
        System.out.println(s.canJump(new int[] {3, 0, 8, 2, 0, 0, 1}));
        // false  expected
        System.out.println(s.canJump(new int[] {1, 0, 1, 0}));
        // true  expected
        System.out.println(s.canJump(new int[] {2, 0, 0}));

        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            // false expected. testcase: https://pastebin.com/vyK34G8L
            String input = sc.next();
            String[] inputStrNums = input.split(",");
            int[] inputNums = new int[inputStrNums.length];
            for (int i = 0; i < inputStrNums.length; i++) {
                inputNums[i] = Integer.parseInt(inputStrNums[i]);
            }
            System.out.println(s.canJump(inputNums));
        }
    }
}