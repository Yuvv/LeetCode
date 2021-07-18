import java.util.Map;
import java.util.HashMap;

/*
 * 0076-minimum-window-substring.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/18
 */
public class Solution {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength) {
            return "";
        }
        Map<Character, Integer> tcCountMap = new HashMap<>();
        for (int i = 0; i < tLength; i++) {
            tcCountMap.put(t.charAt(i), tcCountMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0, j;
        int minLenth = sLength;
        String minStr = "";
        int tcSize = tcCountMap.size();
        for (j = 0; j < sLength; j++) {
            char sc = s.charAt(j);
            Integer scCount = tcCountMap.get(sc);
            if (scCount != null) {
                tcCountMap.put(sc, scCount - 1);
                if (scCount == 1) {
                    tcSize -= 1;
                }
            }
            if (tcSize == 0) {
                while (i < sLength - tLength + 1) {
                    sc = s.charAt(i);
                    scCount = tcCountMap.get(sc);
                    if (scCount != null) {
                        if (scCount < 0) {
                            tcCountMap.put(sc, scCount + 1);
                            i++;
                        } else {
                            break;
                        }
                    } else {
                        i++;
                    }
                }
                if (j - i + 1 <= minLenth) {
                    minLenth = j - i + 1;
                    minStr = s.substring(i, j + 1);
                }
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "BANC"
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        // "a"
        System.out.println(s.minWindow("a", "a"));
        // ""
        System.out.println(s.minWindow("a", "aa"));
    }

}
