import java.util.*;

/*
 * 0424-longest-repeating-character-replacement.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 1970/01/01
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>(16);
        TreeMap<Integer, Set<Character>> numberMap = new TreeMap<>();

        int max = 0;
        int totalCount = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (countMap.containsKey(ch)) {
			    Integer originCount = countMap.get(ch);
                countMap.put(ch, originCount + 1);
                numberMap.get(originCount).remove(ch);
                numberMap.computeIfAbsent(originCount + 1, kk -> new HashSet<>()).add(ch);
		    } else {
                countMap.put(ch, 1);
                numberMap.computeIfAbsent(1, kk -> new HashSet<>()).add(ch);
            }
            totalCount++;

            while (!numberMap.isEmpty() && totalCount - numberMap.lastKey() > k && i < j) {
                ch = s.charAt(i);
                Integer originCount = countMap.get(ch);
                numberMap.get(originCount).remove(ch);
                if (numberMap.get(originCount).isEmpty()) {
                    numberMap.remove(originCount);
                }
                if (originCount > 1) {
                    countMap.put(ch, originCount - 1);
                    numberMap.computeIfAbsent(originCount - 1, kk -> new HashSet<>()).add(ch);
                } else {
                    countMap.remove(ch);
                }
                totalCount--;
                i++;
            }

            max = Math.max(max, totalCount);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.characterReplacement("ABAB", 2));
        // 4
        System.out.println(s.characterReplacement("AABABBA", 1));
    }
}
