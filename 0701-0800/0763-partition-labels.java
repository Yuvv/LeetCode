import java.util.*;

/*
 * 0763-partition-labels.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/12/06
 */
public class Solution {
    public List<Integer> partitionLabels(String str) {
        LinkedList<Integer> res = new LinkedList<>();
        if (str == null || str.isEmpty()) {
            return res;
        }
        Map<Character, Integer> minPosMap = new HashMap<>();
        minPosMap.put(str.charAt(0), 0);
        res.addLast(1);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            res.addLast(1);
            Integer minPos = minPosMap.get(c);
            if (minPos != null) {
                int curLen = i - minPos + 1;
                int curCum = 0;
                while (!res.isEmpty()) {
                    curCum += res.pollLast();
                    if (curCum >= curLen) {
                        break;
                    }
                }
                res.addLast(curCum);
            } else {
                minPosMap.put(c, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [9,8,7]
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
        // [1,1,1,1]
        System.out.println(s.partitionLabels("abcd"));
        // [3,1,1]
        System.out.println(s.partitionLabels("abacd"));
    }
}