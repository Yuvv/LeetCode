import java.util.*;

/*
 * 1218-longest-arithmetic-subsequence-of-given-difference.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/14
 */
public class Solution {
    public int longestSubsequence_tle(int[] arr, int difference) {
        int maxLen = 1;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            TreeSet<Integer> set = map.computeIfAbsent(arr[i], k -> new TreeSet<>());
            set.add(i);
            if (difference == 0) {
                maxLen = Math.max(maxLen, set.size());
            }
        }
        if (difference == 0) {
            return maxLen;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!map.containsKey(num - difference) || map.get(num - difference).first() > i) {
                int len = 1;
                int pos = i;
                while (map.containsKey(num)
                        && map.containsKey(num + difference)
                        && map.get(num + difference).ceiling(pos) != null) {
                    num += difference;
                    pos = map.get(num).ceiling(pos);
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }

    public int longestSubsequence(int[] arr, int difference) {
        int maxLen = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int next = arr[i] + difference;
            int curMax = 1 + map.getOrDefault(next, 0);
            maxLen = Math.max(maxLen, curMax);
            map.put(arr[i], Math.max(curMax, map.getOrDefault(arr[i], 0)));
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.longestSubsequence(new int[] {3,0,-3,4,-4,7,6}, 3));
        // 4
        System.out.println(s.longestSubsequence(new int[] {1,2,3,4}, 1));
        // 1
        System.out.println(s.longestSubsequence(new int[] {1,3,5,7}, 1));
    }
}