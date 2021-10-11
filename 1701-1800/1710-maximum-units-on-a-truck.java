import java.util.Arrays;
import java.util.Comparator;

/*
 * 1710-maximum-units-on-a-truck.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/11
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
        int i = boxTypes.length - 1;
        int total = 0;
        while (i >= 0 && truckSize > 0) {
            int min = Math.min(truckSize, boxTypes[i][0]);
            total += min * boxTypes[i][1];
            truckSize -= min;
            i--;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.maximumUnits(new int[][] {{1,3},{2,2},{3,1}}, 4));
        // 91
        System.out.println(s.maximumUnits(new int[][] {{5,10},{2,5},{4,7},{3,9}}, 10));
    }
}