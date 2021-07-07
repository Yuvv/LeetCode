import java.util.LinkedList;
import java.util.Arrays;

/*
 * 0503-next-greater-element-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/07
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int j = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[j] = -1;
            } else {
                result[j] = nums[stack.peek()];
            }
            stack.push(j);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,-1,2]
        System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{1, 2, 1})));
        // [2,3,4,-1,4]
        System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        // [4,5,5,-1,4]
        System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{1, 4, 3, 5, 2})));
    }
}