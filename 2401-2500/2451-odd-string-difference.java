import java.util.*;
/*
 * 2451-odd-string-difference.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/10/30
 */
public class Solution {
    public String oddString(String[] words) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i < words[0].length(); i++) {
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                int diff = word.charAt(i) - word.charAt(i-1);
                int[] info = map.computeIfAbsent(diff, k -> new int[2]);
                info[0]++;
                info[1] = j;
            }
            if (map.size() > 1) {
                for (int[] info : map.values()) {
                    if (info[0] == 1) {
                        return words[info[1]];
                    }
                }
            } else {
                map.clear();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abc"
        System.out.println(s.oddString(new String[]{
            "adc", "wzy", "abc"
        }));
    }
}