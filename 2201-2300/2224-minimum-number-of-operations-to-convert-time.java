/*
 * 2224-minimum-number-of-operations-to-convert-time.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/21
 */
public class Solution {
    public int convertTime(String current, String correct) {
        int curMin = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
        int corMin = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));
        int diffMin = Math.abs(corMin - curMin);
        int minOp = 0;
        for (int op : java.util.Arrays.asList(60, 15, 5, 1)) {
            minOp += diffMin / op;
            diffMin %= op;
        }
        return minOp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.convertTime("02:30", "04:35"));
        // 1
        System.out.println(s.convertTime("11:00", "11:01"));
    }
}