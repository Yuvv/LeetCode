import java.util.*;
/*
 * 1048-longest-string-chain.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/11
 */
public class Solution {
    private boolean oneCharDiff(String a, String b) {
        if (b.length() - a.length() != 1) {
            return false;
        }
        int cnt = 0;
        for (int i = 0, j = 0; i < a.length() && j < b.length(); ) {
            if (a.charAt(i) != b.charAt(j)) {
                cnt++;
                j++;
                if (cnt > 1) {
                    return false;
                }
                continue;
            }

            i++;
            j++;
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> byLenMap = new HashMap<>();
        for (String w : words) {
            byLenMap.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }
        Map<String, List<String>> predecessorMap = new HashMap<>();
        for (String w : words) {
            List<String> predecessorWords = byLenMap.get(w.length() + 1);
            if (predecessorWords != null) {
                for (String nw : predecessorWords) {
                    if (oneCharDiff(w, nw)) {
                        predecessorMap.computeIfAbsent(w, k -> new ArrayList<>()).add(nw);
                    }
                }
            }
        }
        System.out.println(predecessorMap);
        // dfs
        int max = 0;
        Map<String, Integer> maxMap = new HashMap<>();
        for (String w : words) {
            max = Math.max(max, dfsMax(w, predecessorMap, maxMap));
        }
        return max;
    }

    private Integer dfsMax(String w, Map<String, List<String>> pMap, Map<String, Integer> mMap) {
        if (mMap.containsKey(w)) {
            return mMap.get(w);
        }
        int max = 1;
        if (pMap.containsKey(w)) {
            for (String nw : pMap.get(w)) {
                max = Math.max(max, 1 + dfsMax(nw, pMap, mMap));
            }
        }
        mMap.put(w, max);
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.longestStrChain(new String[]{
            "a", "b", "ba", "bca", "bda", "bdca"
        }));
        // 5
        System.out.println(s.longestStrChain(new String[]{
            "xbc","pcxbcf","xb","cxbc","pcxbc"
        }));
        // 1
        System.out.println(s.longestStrChain(new String[]{
            "abcd", "dbqca"
        }));
    }
}