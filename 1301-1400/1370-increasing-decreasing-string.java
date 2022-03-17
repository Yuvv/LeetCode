import java.util.*;

/*
 * 1370-increasing-decreasing-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/17
 */
public class Solution {
    public String sortString(String s) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!treeMap.isEmpty()) {
            // 1-2-3
            char ch = (char) (treeMap.firstKey() - ((char) 1));
            while (treeMap.ceilingKey(ch) != null) {
                Map.Entry<Character, Integer> entry = treeMap.ceilingEntry(ch);
                sb.append(entry.getKey());
                if (entry.getValue() > 1) {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                } else {
                    treeMap.remove(entry.getKey());
                }
                ch = (char) (entry.getKey() + ((char) 1));
            }
            // 4-5-6
            if (!treeMap.isEmpty()) {
                ch = (char) (treeMap.lastKey() + ((char) 1));
                while (treeMap.floorKey(ch) != null) {
                    Map.Entry<Character, Integer> entry = treeMap.floorEntry(ch);
                    sb.append(entry.getKey());
                    if (entry.getValue() > 1) {
                        treeMap.put(entry.getKey(), entry.getValue() - 1);
                    } else {
                        treeMap.remove(entry.getKey());
                    }
                    ch = (char) (entry.getKey() - ((char) 1));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abccbaabccba"
        System.out.println(s.sortString("aaaabbbbcccc"));
        // "art"
        System.out.println(s.sortString("rat"));
    }
}