/**
 * 3516-find-closest-person.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/22
 */
public class Solution {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if (a > b) {
            return 2;
        } else if (a < b) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.findClosest(2, 7, 4));
    }
}