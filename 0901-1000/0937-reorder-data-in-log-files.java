import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/*
 * 0937-reorder-data-in-log-files.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/17
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Map<String, Integer> map = new HashMap<>(logs.length);
        for (int i = 0; i < logs.length; i++) {
            map.put(logs[i], i);
        }
        Arrays.sort(logs, (s1, s2) -> {
            int index1 = s1.indexOf(' ');
            int index2 = s2.indexOf(' ');
            String id1 = s1.substring(0, index1);
            String content1 = s1.substring(index1 + 1);
            boolean isDigit1 = content1.charAt(0) >= '0' && content1.charAt(0) <= '9';
            String id2 = s2.substring(0, index2);
            String content2 = s2.substring(index2 + 1);
            boolean isDigit2 = content2.charAt(0) >= '0' && content2.charAt(0) <= '9';

            if (isDigit1) {
                if (isDigit2) {
                    // The digit-logs maintain their relative ordering.
                    return map.get(s1) - map.get(s2);
                } else {
                    // The letter-logs come before all digit-logs.
                    return 1;
                }
            } else {
                if (isDigit2) {
                    // The letter-logs come before all digit-logs.
                    return -1;
                } else {
                    // The letter-logs are sorted lexicographically by their contents.
                    // If their contents are the same,
                    // then sort them lexicographically by their identifiers.
                    int val = content1.compareTo(content2);
                    if (val == 0) {
                        return id1.compareTo(id2);
                    } else {
                        return val;
                    }
                }
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        String[] logs = new String[] {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig","let3 art zero"
        };
        System.out.println(Arrays.toString(s.reorderLogFiles(logs)));
        // ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
        logs = new String[] {
            "a1 9 2 3 1",
            "g1 act car",
            "zo4 4 7",
            "ab1 off key dog",
            "a8 act zoo"
        };
        System.out.println(Arrays.toString(s.reorderLogFiles(logs)));
    }
}