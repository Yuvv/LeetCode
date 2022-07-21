import java.util.*;

/*
 * 0792-number-of-matching-subsequences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/20
 */
public class Solution {
    private int[][] buildNextTable(String s) {
        // last row means first position
        int[][] nextTable = new int[s.length() + 1][];
        int[] row = new int[26];
        Arrays.fill(row, -1);
        nextTable[s.length() - 1] = Arrays.copyOf(row, 26);

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'a';
            row[val] = i;
            if (i > 0) {
                nextTable[i - 1]= Arrays.copyOf(row, 26);
            }
        }
        nextTable[s.length()] = row;

        return nextTable;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int[][] nextTable = buildNextTable(s);
        int count = 0;
        for (String word : words) {
            if (word.length() > s.length()) {
                continue;
            }
            // find
            int nextIdx = s.length();
            for (int i = 0; i < word.length(); i++) {
                int val = word.charAt(i) - 'a';
                nextIdx = nextTable[nextIdx][val];
                if (nextIdx < 0) {
                    break;
                }
            }
            if (nextIdx >= 0 && nextIdx < s.length()) {
                count++;
            }
        }
        return count;
    }

    // a little slow, but AC
    public int numMatchingSubseq_hash(String s, String[] words) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new TreeSet<>()).add(i);
        }

        int count = 0;
        for (String word : words) {
            if (word.length() > s.length()) {
                continue;
            }
            Integer fromIdx = -1;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!map.containsKey(ch)) {
                    fromIdx = null;
                    break;
                }
                fromIdx = map.get(ch).ceiling(fromIdx+1);
                if (fromIdx == null) {
                    break;
                }
            }
            if (fromIdx != null) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numMatchingSubseq_tle(
            "dsahjpjauf", new String[] {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}
        ));
        // 3
        System.out.println(s.numMatchingSubseq_tle(
            "abcde", new String[] {"a", "bb", "acd", "ace"}
        ));
    }
}