import java.util.LinkedList;

/*
 * 0946-validate-stack-sequences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/27
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        while (i < pushed.length && j < popped.length) {
            while (i < pushed.length && stack.peek() != popped[j]) {
                stack.push(pushed[i++]);
            }
            while (j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.size() == 1 && stack.peek() == -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.validateStackSequences(
            new int[] {1,2,3,4,5},
            new int[] {4,5,3,2,1}));
        // false
        System.out.println(s.validateStackSequences(
            new int[] {1,2,3,4,5},
            new int[] {4,3,5,1,2}));
    }
}