import java.util.*;

/**
 * 2545-sort-the-students-by-their-kth-score.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/09
 */
public class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> {
            return b[k] - a[k];
        });
        return score;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
        System.out.println(s.sortTheStudents(
            new int[][] {{10,6,9,1}, {7,5,11,2}, {4,8,3,15}}, 2
        ));
    }
}
