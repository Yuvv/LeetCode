import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * 2788-split-strings-by-separator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/25
 */
public class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        return words.stream().
                flatMap(s -> Arrays.stream(s.split("\\" + separator))).
                filter(s -> !s.isEmpty()).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["one","two","three","four","five","six"]
        System.out.println(s.splitWordsBySeparator(
            Arrays.asList("one.two.three","four.five","six"), '.'
        ));
    }
}
