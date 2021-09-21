import java.util.*;
import java.util.stream.Collectors;

/*
 * 1239-maximum-length-of-a-concatenated-string-with-unique-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/21
 */
public class Solution {
    static int[] BIT_MAP = new int[] {
        1,
        1 << 1,
        1 << 2,
        1 << 3,
        1 << 4,
        1 << 5,
        1 << 6,
        1 << 7,
        1 << 8,
        1 << 9,
        1 << 10,
        1 << 11,
        1 << 12,
        1 << 13,
        1 << 14,
        1 << 15,
        1 << 16,
        1 << 17,
        1 << 18,
        1 << 19,
        1 << 20,
        1 << 21,
        1 << 22,
        1 << 23,
        1 << 24,
        1 << 25
    };

    public int maxLength(List<String> arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 0);
        Set<Integer> set = arr.stream()
                .map(str -> {
                    int val = 0;
                    for (int i = 0; i < str.length(); i++) {
                        int chVal = BIT_MAP[str.charAt(i) - 'a'];
                        if ((val & chVal) > 0) {
                            return 0;
                        }
                        val |= chVal;
                    }
                    countMap.put(val, str.length());
                    return val;
                }).filter(x -> x > 0)
                .collect(Collectors.toSet());

        int maxLength = 0;
        List<Integer> combinations = new ArrayList<>();
        combinations.add(0);
        for (Integer each : set) {
            int lastSize = combinations.size();
            for (int i = 0; i < lastSize; i++) {
                if ((combinations.get(i) & each) > 0) {
                    continue;
                }
                int val = combinations.get(i) | each;
                countMap.put(val, countMap.get(each) + countMap.get(combinations.get(i)));
                maxLength = Math.max(maxLength, countMap.get(val));
                combinations.add(val);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxLength(Arrays.asList("un", "iq", "ue")));
        // 6
        System.out.println(s.maxLength(Arrays.asList("cha", "r", "act", "ers")));
        // 26
        System.out.println(s.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}