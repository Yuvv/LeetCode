import java.util.*;
import java.util.stream.Collectors;

/*
 * 0923-3sum-with-multiplicity.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/06
 */
public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long count = 0L;
        final long MOD = 1000000007L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<String> keySet = new HashSet<>();
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Integer, Integer> a = entries.get(i);
            if (a.getKey() * 3 == target && a.getValue() >= 3) {
                // 3 same key
                count += a.getValue().longValue() * (a.getValue().longValue() - 1L) * (a.getValue().longValue() - 2L) / 6L;
                count %= MOD;
            }
            int other = target - a.getKey() * 2;
            if (map.containsKey(other) && a.getValue() >= 2) {
                if (!a.getKey().equals(other)) {
                    // 2 same key
                    count += a.getValue() * (a.getValue() - 1) / 2 * map.get(other);
                    count %= MOD;
                }
            }
            for (int j = i + 1; j < entries.size(); j++) {
                Map.Entry<Integer, Integer> b = entries.get(j);
                other = target - a.getKey() - b.getKey();
                if (map.containsKey(other)) {
                    if (!a.getKey().equals(other) && !b.getKey().equals(other)) {
                        String key = Arrays.asList(other, a.getKey(), b.getKey()).stream().sorted().map(Objects::toString).collect(Collectors.joining(","));
                        if (!keySet.contains(key)) {
                            // no same key
                            count += a.getValue() * b.getValue() * map.get(other);
                            count %= MOD;
                        }
                        keySet.add(key);
                    }
                }
            }
        }
        return (int) count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 95
        System.out.println(s.threeSumMulti(
            new int[] {4, 11, 3, 2, 9, 8, 7, 10, 9, 7, 9, 3, 3, 4, 8, 1, 5, 9, 3, 6, 9, 2, 2, 9, 5, 9, 3, 4, 4, 7},
            9
        ));
        // 20
        System.out.println(s.threeSumMulti(
            new int[] {1,1,2,2,3,3,4,4,5,5},
            8
        ));
        // 12
        System.out.println(s.threeSumMulti(
            new int[] {1,1,2,2,2,2},
            5
        ));
        // 495500972
        // 2147483647
        System.out.println(Integer.MAX_VALUE);
    }

}
