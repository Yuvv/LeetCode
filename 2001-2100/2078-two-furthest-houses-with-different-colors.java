/*
 * 2078-two-furthest-houses-with-different-colors.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/21
 */
public class Solution {
    public int maxDistance(int[] colors) {
        return this.getMaxDis(colors, 0, 0);
    }

    public int getMaxDis(int[] colors, int lo, int curMax) {
        if (colors.length - lo < curMax) {
            return curMax;
        }

        int i = colors.length - 1;
        for (; i >= lo; i--) {
            if (colors[i] != colors[lo]) {
                break;
            }
        }
        curMax = Math.max(i - lo, curMax);

        int j = lo + 1;
        for (; j < colors.length; j++) {
            if (colors[j] != colors[lo]) {
                break;
            }
        }
        int nextDis = getMaxDis(colors, j, curMax);

        return Math.max(curMax, nextDis);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxDistance(new int[] {1,1,1,6,1,1,1}));
        // 4
        System.out.println(s.maxDistance(new int[] {1,8,3,8,3}));
    }
}