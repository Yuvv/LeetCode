import java.util.*;

/*
 * 1128-number-of-equivalent-domino-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/04
 */
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>(dominoes.length);
        for (int[] dom : dominoes) {
            String key;
            if (dom[0] > dom[1]) {
                key = dom[1] + "," + dom[0];
            } else {
                key = dom[0] + "," + dom[1];
            }
            int originCount = map.getOrDefault(key, 0);
            count += originCount;
            map.put(key, originCount + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numEquivDominoPairs(
            new int[][] {
                {1,2},
                {2,1},
                {3,4},
                {5,6}
            }
        ));
    }
}