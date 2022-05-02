import java.util.*;

/*
 * 1366-rank-teams-by-votes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/02
 */
public class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>(32);
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char ch = vote.charAt(i);
                int[] varr = map.computeIfAbsent(ch, k -> new int[vote.length()]);
                varr[i]++;
            }
        }
        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) -> {
            int[] aarr = a.getValue();
            int[] barr = b.getValue();
            for (int i = 0; i < aarr.length; i++) {
                if (aarr[i] > barr[i]) {
                    return -1;
                } else if (aarr[i] < barr[i]) {
                    return 1;
                }
            }
            return (a.getKey() - b.getKey());
        });
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, int[]> entry = pq.poll();
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "ACB"
        System.out.println(s.rankTeams(
            new String[] {"ABC", "ACB", "ABC", "ACB", "ACB"}
        ));
        // "XWYZ"
        System.out.println(s.rankTeams(
            new String[] {"WXYZ", "XYZW"}
        ));
    }
}