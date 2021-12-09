import java.util.*;

/*
 * 1306-jump-game-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/09
 */
public class Solution {
    private Map<Integer, Boolean> cacheMap;
    private Set<Integer> processingSet;

    public boolean canReach(int[] arr, int start) {
        cacheMap = new HashMap<>();
        processingSet = new HashSet<>();

        return isReachable(arr, start);
    }

    public boolean isReachable(int[] arr, int start) {
        if (cacheMap.containsKey(start)) {
            return cacheMap.get(start);
        }
        if (processingSet.contains(start)) {
            return false;
        }
        if (start < 0 || start >= arr.length) {
            return false;
        }
        processingSet.add(start);
        boolean res = false;
        if (arr[start] == 0) {
            res = true;
        } else if (isReachable(arr, start - arr[start])) {
            res = true;
        } else if (isReachable(arr, start + arr[start])) {
            res = true;
        }
        processingSet.remove(start);
        cacheMap.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canReach(new int[] {4,2,3,0,3,1,2}, 5));
        // true
        System.out.println(s.canReach(new int[] {4,2,3,0,3,1,2}, 0));
        // false
        System.out.println(s.canReach(new int[] {3,0,2,1,2}, 2));

    }
}