import java.util.*;

/*
 * 0456-132-pattern.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/08
 */
public class Solution {

    public boolean find132pattern_stack(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                // 保证 stack 是单调的递减的序列
                // third 设置为第一个小于当前数字的最大的数
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE;
        int top = n;

        for (int i = n - 1; i >= 0; i--) {
            // Assumes that third is already smaller than some element nums[j] where j is between i and third's index
            // We find a "132" pattern if nums[i] < third
            if (nums[i] < third) {
                return true;
            }

            // Now we have nums[i] >= third

            // We now view nums[i] as the second element, and increase third as much as possible, but keep third < nums[i].
            // We do this because we want to maximize the chance of finding a "132" pattern in a future iteration.
            // Note that {nums[top], ..., nums[n-1]} is a stack has the following property:
            // nums[top] <= nums[top+1] <= ... <= nums[n-1]
            while (top < n && nums[i] > nums[top]) {
                third = nums[top];
                top++;
            }

            // Now we have nums[i] <= nums[top] (which indicates that the stack is monotonical)
            // We push nums[i] to the "stack"
            top--;
            nums[top] = nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.find132pattern(new int[] {1, 2, 3, 4}));
        // true
        System.out.println(s.find132pattern(new int[] {3, 1, 4, 2}));
        // true
        System.out.println(s.find132pattern(new int[] {-1, 3, 2, 0}));
    }
}