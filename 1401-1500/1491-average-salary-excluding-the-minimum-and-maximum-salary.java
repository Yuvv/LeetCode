/*
 * 1491-average-salary-excluding-the-minimum-and-maximum-salary.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/03
 */
public class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int e : salary) {
            min = Math.min(e, min);
            max = Math.max(e, max);
            sum += e;
        }
        return (double)(sum - min - max) / (salary.length - 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2500
        System.out.println(s.average(new int[] {4000,3000,1000,2000}));
    }
}