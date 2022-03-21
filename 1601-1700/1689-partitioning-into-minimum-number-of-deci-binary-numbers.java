/*
 * 1689-partitioning-into-minimum-number-of-deci-binary-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/21
 */
public class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            int val = n.charAt(i) - '0';
            if (val == 9) {
                return val;
            }
            max = Math.max(max, val);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minPartitions("32"));
        // 9
        System.out.println(s.minPartitions("27346209830709182346"));
    }
}