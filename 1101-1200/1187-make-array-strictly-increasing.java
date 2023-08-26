import java.util.*;

/*
 * 1187-make-array-strictly-increasing.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/17
 */
public class Solution {
    private Map<Integer, Map<Integer, Integer>> dpMap;
    private TreeSet<Integer> arr2Set;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        arr2Set = new TreeSet<>();
        for (int n : arr2) {
            arr2Set.add(n);
        }
        dpMap = new HashMap<>();

        int answer = dfs(0, -1, arr1);
        if (answer >= Integer.MAX_VALUE-arr1.length) {
            return -1;
        }
        return answer;
    }

    private int dfs(int i, int prev, int[] arr1) {
        if (i >= arr1.length) {
            return 0;
        }
        if (dpMap.containsKey(i)) {
            Integer v = dpMap.get(i).get(prev);
            if (v != null) {
                return v;
            }
        }

        // if we replace i's value
        int rep = Integer.MAX_VALUE-arr1.length;
        Integer hi = arr2Set.higher(prev);
        if (hi != null) {
            rep = 1 + dfs(i+1, hi, arr1);
        }
        // if we don't replace
        int keep = Integer.MAX_VALUE-arr1.length;
        if (arr1[i] > prev) {
            keep = dfs(i+1, arr1[i], arr1);
        }
        int res = Math.min(rep, keep);
        dpMap.computeIfAbsent(i, k -> new HashMap<>()).put(prev, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.makeArrayIncreasing(
            new int[] {1,5,3,6,7},
            new int[] {1,3,2,4}
        ));
        // 2
        System.out.println(s.makeArrayIncreasing(
            new int[] {1,5,3,6,7},
            new int[] {1,3,4}
        ));
        // -1
        System.out.println(s.makeArrayIncreasing(
            new int[] {1,5,3,6,7},
            new int[] {1,6,3,3}
        ));

    }
}