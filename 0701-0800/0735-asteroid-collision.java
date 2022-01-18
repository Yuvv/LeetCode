import java.util.Arrays;
import java.util.LinkedList;

/*
 * 0735-asteroid-collision.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/18
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int ast : asteroids) {
            if (ast < 0) {
                ast = -ast;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < ast) {
                        stack.pop();
                    } else if (stack.peek() > ast) {
                        ast = 0;
                        break;
                    } else {
                        stack.pop();
                        ast = 0;
                        break;
                    }
                }
                if (ast > 0) {
                    stack.push(-ast);
                }
            } else {
                stack.push(ast);
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,10]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] {5,10,-5})));
        // []
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] {8,-8})));
        // [10]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] {10,2,-5})));
    }
}