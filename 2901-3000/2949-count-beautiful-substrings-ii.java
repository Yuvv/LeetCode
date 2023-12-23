import java.util.*;

/**
 * 2949-count-beautiful-substrings-ii
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/19
 */
public class Solution {

    public int beautifulSubstrings(String s, int k) {
        // get min L
        int L;
        for (L = 1; L * L % (4 * k) > 0; L++)
            ;
        // check all nL
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(L);
        for (int i = 0; i < L; i++) {
            Map<Integer, Integer> vMap = new HashMap<>();
            if (i == L - 1) { // at -1 position
                vMap.put(0, 1);
            }
            map.put(i, vMap);
        }
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                v += 1;
            } else {
                v -= 1;
            }
            // vMap record all value count
            Map<Integer, Integer> vMap = map.get(i % L);
            int c = vMap.getOrDefault(v, 0);
            vMap.put(v, c + 1);
        }
        int res = 0;
        for (Map<Integer, Integer> vMap : map.values()) {
            for (Integer c : vMap.values()) {
                res += (c - 1) * c / 2;
            }
        }
        return res;
    }

    public int beautifulSubstrings_tle(String s, int k) {
        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= (s.length() + 1) / 2; i++) {
            if (i * i % k == 0) {
                candidate.add(i);
            }
        }
        int[] prefixSum = new int[s.length()];
        Map<Integer, Set<Integer>> prefixSumMap = new HashMap<>();
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int current = prev;
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                current += 1;
            }
            prefixSum[i] = current;
            prefixSumMap.computeIfAbsent(current, x -> new HashSet<>()).add(i);
            prev = current;
        }

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            prev = 0;
            if (i > 0) {
                prev = prefixSum[i - 1];
            }
            for (Integer nv : candidate) {
                int j = nv * 2 - 1 + i;
                if (j >= s.length()) {
                    break;
                }
                int next = prev + nv;
                if (prefixSumMap.containsKey(next)) {
                    if (prefixSumMap.get(next).contains(j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.beautifulSubstrings("baeyh", 2));
        // 3
        System.out.println(s.beautifulSubstrings("abba", 1));
        // 0
        System.out.println(s.beautifulSubstrings("bcdf", 1));
    }
}
