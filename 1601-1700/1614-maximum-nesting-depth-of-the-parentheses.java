/**
 * 1614-maximum-nesting-depth-of-the-parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/04/08
 */
public class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                    break;
                case ')':
                    depth--;
                    break;
                default:
                    break;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxDepth("(1+(2*3)+((8)/4))+1"));
        // 3
        System.out.println(s.maxDepth("(1)+((2))+(((3)))"));
    }
}