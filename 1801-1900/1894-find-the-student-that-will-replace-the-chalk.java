/**
 * 1894-find-the-student-that-will-replace-the-chalk.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/02
 */
public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long[] cumsum = new long[chalk.length];
        cumsum[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            cumsum[i] = cumsum[i-1] + chalk[i];
        }
        long lk =  ((long)k) % cumsum[cumsum.length-1] ;
        int i = 0;
        int j = cumsum.length-1;
        while (i < j) {
            int m = (i + j) / 2;
            if (cumsum[m] < lk) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        if (cumsum[i] == lk) {
            return i+1;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.chalkReplacer(new int[] {5,1,5}, 22));
        // 1
        System.out.println(s.chalkReplacer(new int[] {3,4,1,2}, 25));
    }
}
