import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 1387-sort-integers-by-the-power-value.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/22
 */
public class Solution {
    Map<Integer, Integer> cacheMap;

    public int getKth(int lo, int hi, int k) {
        this.cacheMap = new HashMap<>();
        this.cacheMap.put(1, 0);

        int[][] arr = new int[hi - lo + 1][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = lo + i;
            arr[i][1] = getSetpCount(lo + i);
        }

        Arrays.sort(arr, Comparator.comparing(a -> a[1]));

        return arr[k - 1][0];
    }

    public int getSetpCount(int val) {
        if (cacheMap.containsKey(val)) {
            return cacheMap.get(val);
        }
        int step;
        if (val % 2 == 0) {
            // even
            step = 1 + getSetpCount(val / 2);
        } else {
            step = 1 + getSetpCount(3 * val + 1);
        }
        cacheMap.put(val, step);
        return step;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.getKth(12, 15, 2));
        // 7
        System.out.println(s.getKth(7, 11, 4));
        // 1
        System.out.println(s.getKth(1, 1, 1));
        // 13
        System.out.println(s.getKth(10, 20, 5));
        // 570
        System.out.println(s.getKth(1, 1000, 777));
    }
}