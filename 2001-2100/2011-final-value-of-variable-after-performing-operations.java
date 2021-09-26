/*
 * 2011-final-value-of-variable-after-performing-operations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/26
 */
public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.charAt(0) == '+' || op.charAt(2) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
        // 3
        System.out.println(s.finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
        // 3
        System.out.println(s.finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));
    }
}