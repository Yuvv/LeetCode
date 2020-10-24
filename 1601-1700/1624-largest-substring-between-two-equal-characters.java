import java.util.*;

/*
 * 1624-largest-substring-between-two-equal-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/10/24
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> chIdxMap = new HashMap<>();
        int maxValue = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<Integer> list = chIdxMap.computeIfAbsent(ch, c -> new ArrayList<>(2));
            if (list.size() < 2) {
                list.add(i);
            } else {
                list.set(1, i);
            }
            if (list.size() == 2) {
                maxValue = Math.max(maxValue, list.get(1) - list.get(0) - 1);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(1 == s.maxLengthBetweenEqualCharacters("aaa"));
        System.out.println(2 == s.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(-1 == s.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(4 == s.maxLengthBetweenEqualCharacters("cabbac"));
    }
}