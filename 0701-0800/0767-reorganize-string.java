import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 0767-reorganize-string
 *
 * @date 2024/1/13
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public String reorganizeString(String s) {
        int[] cntArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cntArr[ch-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1]-a[1]);
        for (int i = 0;i<cntArr.length;i++) {
            if (cntArr[i] > 0) {
                pq.add(new int[]{i, cntArr[i]});
            }
        }
        // greedy
        StringBuilder sb = new StringBuilder();
        char last = ' ';
        List<int[]> candList = new ArrayList<>();
        while ( !pq.isEmpty() ) {
            candList.clear();
            int[] candidate = pq.poll();
            while ( candidate != null && ('a'+candidate[0]) == last) {
                candList.add(candidate);
                candidate = pq.poll();
            }
            if (candidate != null) {
                char ch = (char) ('a' + candidate[0]);
                sb.append(ch);
                last = ch;
                candidate[1]--;
                if (candidate[1] > 0) {
                    pq.add(candidate);
                }
            } else if (candList.size() > 0) {
                return "";
            }
            pq.addAll(candList);
        }
        return sb.toString();    }

    public static void main(String[] args) {
        Solution s  =new Solution();
        // "aba"
        System.out.println(s.reorganizeString("aab"));
        // ""
        System.out.println(s.reorganizeString("aaab"));
    }
}
