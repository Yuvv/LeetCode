import java.util.*;

/**
 * 0846-hand-of-straights.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/06
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int e : hand) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> first = map.firstEntry();
            if (first.getValue() == 1) {
                map.remove(first.getKey());
            } else {
                map.put(first.getKey(), first.getValue() - 1);
            }
            int key = first.getKey();
            for (int i = key + 1; i < key + groupSize; i++) {
                Integer value = map.get(i);
                if (value == null) {
                    return false;
                }
                if (value == 1) {
                    map.remove(i);
                } else {
                    map.put(i, value-1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        // false
        System.out.println(s.isNStraightHand(new int[]{1,2,3,4,5}, 4));
    }
}