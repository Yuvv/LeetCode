import java.util.*;

/*
 * 1944-number-of-visible-people-in-a-queue.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/24
 */
public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] arr = new int[heights.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            int h = heights[i];
            int count = 0;
            while (!stack.isEmpty() && heights[stack.peek()] <= h) {
                stack.pop();
                count++;
            }
            if (!stack.isEmpty()) {
                // has a higher person
                count++;
            }
            arr[i] = count;
            stack.push(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,1,2,1,1,0]
        System.out.println(Arrays.toString(
            s.canSeePersonsCount(new int[] {10,6,8,5,11,9})
        ));
        // [4,1,1,1,0]
        System.out.println(Arrays.toString(
            s.canSeePersonsCount(new int[] {5,1,2,3,10})
        ));
    }
}