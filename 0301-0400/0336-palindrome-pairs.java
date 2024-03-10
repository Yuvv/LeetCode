import java.util.*;

/*
 * 0336-palindrome-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/18
 */
public class Solution {
    static String reverse(String s) {
        char[] csh = s.toCharArray();
        int i = 0;
        int j = csh.length-1;
        while (i < j) {
            char tch = csh[i];
            csh[i] = csh[j];
            csh[j] = tch;
            i++;
            j--;
        }
        return new String(csh);
    }

    static boolean isPalindrome(String word, int from, int to) {
        while (from < to) {
            if (word.charAt(from) != word.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> sMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            sMap.computeIfAbsent(reverse(words[i]), k -> new ArrayList<>()).add(i);
        }

        Map<Integer, Set<Integer>> resMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> indexList = sMap.get(word);
            if (indexList != null) {
                for (Integer idx : indexList) {
                    if (idx != i) {
                        resMap.computeIfAbsent(i, k -> new HashSet<>()).add(idx);
                    }
                }
            }
            for (int j = 0; j <= word.length(); j++) { 
                // take other as suffix
                if (isPalindrome(word, j, word.length()-1)) {
                    String sub = word.substring(0, j);
                    indexList = sMap.get(sub);
                    if (indexList != null) {
                        for (Integer idx : indexList) {
                            if (idx != i) {
                                resMap.computeIfAbsent(i, k -> new HashSet<>()).add(idx);
                            }
                        }
                    }
                }
                // take other as prefix
                if (j < word.length() && isPalindrome(word, 0, j)) {
                    String sub = word.substring(j+1);
                    indexList = sMap.get(sub);
                    if (indexList != null) {
                        for (Integer idx : indexList) {
                            if (idx != i) {
                                resMap.computeIfAbsent(idx, k -> new HashSet<>()).add(i);
                            }
                        }
                    }
                }
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : resMap.entrySet()) {
            for (Integer o : entry.getValue()) {
                resList.add(Arrays.asList(entry.getKey(), o));
            }
        }

        return resList;    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,1],[1,0],[3,2],[2,4]]
        System.out.println(s.palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
        // [[0,1],[1,0]]
        System.out.println(s.palindromePairs(new String[] { "bat", "tab", "cat" }));
        // [[0,1],[1,0]]
        System.out.println(s.palindromePairs(new String[] { "a", "" }));
    }
}

