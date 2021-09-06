import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/*
 * 0451-sort-characters-by-frequency.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/06
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .flatMap(e -> {
                    Character[] arr = new Character[e.getValue()];
                    Arrays.fill(arr, e.getKey());
                    return Arrays.stream(arr);
                })
                .map(Objects::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 'eert'
        System.out.println(s.frequencySort("tree"));
        // 'aaaccc'
        System.out.println(s.frequencySort("cccaaa"));
    }
}