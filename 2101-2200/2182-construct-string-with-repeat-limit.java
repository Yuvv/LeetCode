import java.util.*;
/*
 * 2182-construct-string-with-repeat-limit.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/21
 */
public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!treeMap.isEmpty()) {
            Map.Entry<Character, Integer> lastEntry = treeMap.pollLastEntry();
            int times = 0;
            while (times < lastEntry.getValue() && times < repeatLimit) {
                sb.append(lastEntry.getKey());
                times++;
            }
            if (lastEntry.getValue() > repeatLimit) {
                Map.Entry<Character, Integer> nextEntry = treeMap.lastEntry();
                if (nextEntry == null) {
                    break;
                }
                sb.append(nextEntry.getKey());
                if (nextEntry.getValue() == 1) {
                    treeMap.remove(nextEntry.getKey());
                } else {
                    treeMap.put(nextEntry.getKey(), nextEntry.getValue() - 1);
                }

                treeMap.put(lastEntry.getKey(), lastEntry.getValue() - repeatLimit);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "zzcccac"
        System.out.println(s.repeatLimitedString("cczazcc", 3));
        // "bbabaa"
        System.out.println(s.repeatLimitedString("aababab", 2));
    }
}