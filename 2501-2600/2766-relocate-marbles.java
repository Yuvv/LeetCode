import java.util.*;
import java.util.stream.*;

/**
 * 2766-relocate-marbles.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/24
 */
public class Solution {
    public List<Integer> relocateMarbles_all(int[] nums, int[] moveFrom, int[] moveTo) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int n : nums) {
            tm.put(n, tm.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            if (!tm.containsKey(moveFrom[i])) {
                continue;
            }
            tm.put(moveTo[i], tm.getOrDefault(moveTo[i], 0) + tm.getOrDefault(moveFrom[i], 0));
            tm.remove(moveFrom[i]);
        }
        return tm.entrySet().stream().flatMap(e -> {
            Stream.Builder<Integer> b = Stream.builder();
            for (int i = 0; i < e.getValue(); i++) {
                b.add(e.getKey());
            }
            return b.build();
        }).sorted().collect(Collectors.toList());
    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,6,8,9]
        System.out.println(s.relocateMarbles(
            new int[] {1,6,7,8}, new int[] {1,7,2}, new int[] {2,9,5}
        ));
        // [2]
        System.out.println(s.relocateMarbles(
            new int[] {1,2,3,3}, new int[] {1,3}, new int[] {2,2}
        ));
    }
}
