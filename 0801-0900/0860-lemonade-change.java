import java.util.*;

/*
 * 0860-lemonade-change.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/10
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int diff;
        for (int b : bills) {
            diff = b - 5;
            while (diff > 0) {
                Map.Entry<Integer, Integer> entry = treeMap.floorEntry(diff);
                if (entry == null) {
                    return false;
                }
                if (entry.getValue() == 1) {
                    treeMap.remove(entry.getKey());
                } else {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                }
                diff -= entry.getKey();
            }
            treeMap.put(b, treeMap.getOrDefault(b, 0) + 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.lemonadeChange(new int[]{5,5,5,10,20}));
        // false
        System.out.println(s.lemonadeChange(new int[]{5,5,10,10,20}));
        // true
        System.out.println(s.lemonadeChange(new int[]{5,5,10}));
        // false
        System.out.println(s.lemonadeChange(new int[]{10,10}));
    }
}