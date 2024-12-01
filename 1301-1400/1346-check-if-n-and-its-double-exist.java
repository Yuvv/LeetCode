import java.util.*;

/**
 * 1346-check-if-n-and-its-double-exist.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/12/01
 */
public class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        for (int a : arr) {
            if (a == 0) {
                if (map.containsKey(a) && map.get(a) > 1) {
                    return true;
                }
            } else {
                if (map.containsKey(a*2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkIfExist(new int[]{10,2,5,3}));
        // false
        System.out.println(s.checkIfExist(new int[]{3,1,7,11}));
    }
}
