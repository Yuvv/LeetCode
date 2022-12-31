import java.util.*;
import java.util.stream.*;

/*
 * 2506-count-pairs-of-similar-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/12/31
 */
public class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String each : words) {
            Set<Character> set = new TreeSet();
            for (int i = 0; i < each.length(); i++) {
                set.add(each.charAt(i));
            }
            each = set.stream().map(Objects::toString).collect(Collectors.joining(""));
            map.put(each, map.getOrDefault(each, 0) + 1);
        }
        int cnt = 0;
        for (Integer c : map.values()) {
            cnt += c * (c - 1) / 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.similarPairs(
            new String[] {"aba", "aabb", "abcd", "bac", "aabc"}
        ));
        // 3
        System.out.println(s.similarPairs(
            new String[] {"aabb", "ab", "ba"}
        ));
    }
}