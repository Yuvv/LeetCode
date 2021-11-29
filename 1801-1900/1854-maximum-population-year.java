import java.util.Map;
import java.util.HashMap;

/*
 * 1854-maximum-population-year.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/29
 */
public class Solution {
    public int maximumPopulation(int[][] logs) {
        int maxCnt = 0;
        int earliest = logs[0][0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] people : logs) {
            for (int i = people[0]; i < people[1]; i++) {
                int val = map.getOrDefault(i, 0) + 1;
                map.put(i, val);
                if (maxCnt < val) {
                    maxCnt = val;
                    earliest = i;
                } else if (maxCnt == val) {
                    earliest = Math.min(earliest, i);
                }
            }
        }
        return earliest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1993
        System.out.println(s.maximumPopulation(new int[][] {
            {1993,1999},
            {2000,2010}
        }));
        // 1960
        System.out.println(s.maximumPopulation(new int[][] {
            {1950,1961},
            {1960,1971},
            {1970,1981}
        }));
    }
}