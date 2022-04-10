/*
 * 1598-crawler-log-folder.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/10
 */
public class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String op : logs) {
            if ("../".equals(op)) {
                if (level > 0) {
                    level--;
                }
            } else if (!"./".equals(op)) {
                level++;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minOperations(
            new String[]{"d1/", "d2/", "../", "d21/", "./"}
        ));
        // 3
        System.out.println(s.minOperations(
            new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}
        ));
        // 0
        System.out.println(s.minOperations(
            new String[]{"d1/", "../", "../", "../"}
        ));
    }
}