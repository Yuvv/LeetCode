import java.util.*;

/*
 * 1481-least-number-of-unique-integers-after-k-removals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/10/26
 */

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // count each element
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int a : arr) {
            int count = numCountMap.getOrDefault(a, 0);
            numCountMap.put(a, count + 1);
        }
        // count each count
        Map<Integer, Integer> counterTreeMap = new TreeMap<>();
        numCountMap.forEach((key, val) -> {
            int count = counterTreeMap.getOrDefault(val, 0);
            counterTreeMap.put(val, count + 1);
        });
        // do remove
        Iterator<Map.Entry<Integer, Integer>> it = counterTreeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (k == 0) {
                break;
            } else {
                int curItCount = entry.getKey() * entry.getValue();
                if (curItCount > k) {
                    // 减去 k 个之后还剩的 counter 的数量
                    int d = (int) Math.floor((double) (curItCount - k) / entry.getKey());
                    // 余数，有余数则需要另外 +1
                    int r = (curItCount - k) % entry.getKey();
                    entry.setValue(d);
                    if (r > 0) {
                        counterTreeMap.put(r, 1);
                    }
                    break;
                } else {
                    k -= curItCount;
                    it.remove();
                }
            }
        }
        return counterTreeMap.values().stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(1 == s.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(2 == s.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
        System.out.println(1 == s.findLeastNumOfUniqueInts(new int[]{1, 1, 2, 2, 2, 2, 2}, 3));
        System.out.println(1 == s.findLeastNumOfUniqueInts(new int[]{5, 5, 4, 3, 2, 4, 4, 4, 5}, 7));
        System.out.println(3 == s.findLeastNumOfUniqueInts(new int[]{2, 4, 1, 8, 3, 5, 1, 3}, 3));
    }
}