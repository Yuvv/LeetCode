import java.util.Map;

class Solution {
    /**
     * 判断单词是否按字典序 https://leetcode.com/problems/verifying-an-alien-dictionary/
     *
     * @param words 单词列表
     * @param order 字母顺序表
     * @return true or false
     */
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>(order.length());
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        int pos = 1;
        int result;
        while (pos < words.length) {
            result = compare(words[pos - 1], words[pos], orderMap);
            if (result > 0) {
                return false;
            }
            pos++;
        }

        return true;
    }

    /**
     * 按照字母顺序表比较两个单词
     *
     * @param word1    单词1
     * @param word2    单词2
     * @param orderMap 字母顺序表
     * @return 大于、小于、等于 0
     */
    private int compare(String word1, String word2, Map<Character, Integer> orderMap) {
        int len1 = word1.length();
        int len2 = word2.length();
        int pos = 0;
        int val1, val2;
        while (pos < len1 && pos < len2) {
            val1 = orderMap.get(word1.charAt(pos));
            val2 = orderMap.get(word2.charAt(pos));
            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            }
            pos++;
        }
        return len1 - len2;
    }
}