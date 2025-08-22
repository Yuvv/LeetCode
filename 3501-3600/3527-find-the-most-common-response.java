import java.util.*;
/**
 * 3527-find-the-most-common-response.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/22
 */
public class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> cntMap = new HashMap<>();
        String maxstr = "";
        int maxval = 0;
        for (List<String> row : responses) {
            Set<String> set = new HashSet<>();
            for (String s : row) {
                if (set.contains(s)) {
                    continue;
                }
                set.add(s);
                int v = cntMap.getOrDefault(s, 0) + 1;
                cntMap.put(s, v);
                if (v > maxval) {
                    maxval = v;
                    maxstr = s;
                } else if (v == maxval) {
                    if (s.compareTo(maxstr) < 0) {
                        maxstr = s;  // retain smallest
                    }
                }
            }
        }
        return maxstr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "good"
        System.out.println(s.findCommonResponse(
            Arrays.asList(
                Arrays.asList("good", "ok", "good", "ok"),
                Arrays.asList("ok", "ok", "good", "bad", "ok"),
                Arrays.asList("good"),
                Arrays.asList("bad")
            )
        ));
    }
}