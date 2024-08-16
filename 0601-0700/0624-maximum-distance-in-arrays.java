import java.util.Arrays;
import java.util.List;

/**
 * 0624-maximum-distance-in-arrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/16
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int mini = 0;
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int maxi = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> a = arrays.get(i);
            if (min > a.get(0)) {
                min = a.get(0);
                mini = i;
            }
            if (max < a.get(a.size()-1)) {
                max = a.get(a.size()-1);
                maxi = i;
            }
        }
        if (mini != maxi) {
            return max - min;
        }
        int mdis = 0;
        for (int i = 0; i < arrays.size(); i++) {
            if (i != mini) {
                mdis = Math.max(mdis, arrays.get(i).get(arrays.get(i).size()-1) - min);
            }
        }
        for (int i = 0; i < arrays.size(); i++) {
            if (i != maxi) {
                mdis = Math.max(mdis, max - arrays.get(i).get(0));
            }
        }
        return mdis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxDistance(
            Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5), Arrays.asList(1,2,3))));
        // 0
        System.out.println(s.maxDistance(
            Arrays.asList(Arrays.asList(1), Arrays.asList(1), Arrays.asList(1))));
    }
}
