import java.util.*;

/*
 * 2007-find-original-array-from-doubled-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/26
 */
public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int e : changed) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int i = 0;
        while (!countMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = countMap.entrySet().iterator().next();
            int key = entry.getKey();
            int doubleKey = key * 2;
            if (!countMap.containsKey(doubleKey)) {
                return new int[0];
            }
            int value = entry.getValue();
            int doubleValue = countMap.get(doubleKey);
            if (key == 0) {
                if (value % 2 == 1) {
                    return new int[0];
                } else {
                    res[i++] = key;
                    countMap.remove(key);
                    continue;
                }
            }
            if (doubleValue < value) {
                return new int[0];
            }
            while (value > 0) {
                res[i] = key;
                i++;
                value--;
                doubleValue--;
            }
            countMap.remove(key);
            if (doubleValue > 0) {
                countMap.put(doubleKey, doubleValue);
            } else {
                countMap.remove(doubleKey);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,4]
        System.out.println(Arrays.toString(s.findOriginalArray(new int[] {1,3,4,2,6,8})));
        // []
        System.out.println(Arrays.toString(s.findOriginalArray(new int[] {6,3,0,1})));
        // [1]
        System.out.println(Arrays.toString(s.findOriginalArray(new int[] {1})));
    }
}