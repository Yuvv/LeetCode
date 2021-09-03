import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/*
 * 0819-most-common-word.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/03
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = Stream.of(banned).map(String::toLowerCase).collect(Collectors.toSet());
        Map<String, Long> countMap = Stream.of(paragraph.split("[ \"!?',;.\"]+"))
            .filter(s -> s.length() > 0)
            .map(String::toLowerCase)
            .filter(s -> !bannedSet.contains(s))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long max = 0L;
        String s = null;
        for (Map.Entry<String, Long> entry : countMap.entrySet()) {
            if (entry.getValue() > max) {
                s = entry.getKey();
                max = entry.getValue();
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ball
        System.out.println(s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        // a
        System.out.println(s.mostCommonWord("a.", new String[0]));
        // b
        System.out.println(s.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}