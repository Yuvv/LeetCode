class Solution {
    /**
     * 选出单词表中的单词拼接后再某字符串中的位置
     * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
     *
     * @param s     字符串
     * @param words 单词表
     * @return 索引列表
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        if (words.length == 0) {
            return resultList;
        }
        // 统计单词和计数
        Map<String, Long> wordCounterMap = Stream.of(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int wordLength = words[0].length();
        if (s.length() < wordLength) {
            return resultList;
        }
        // 统计字符串中哪个位置开始有单词
        Map<Integer, String> wordIndexMap = new HashMap<>();
        for (int i = 0; i <= s.length() - wordLength; i++) {
            String tempString = s.substring(i, i + wordLength);
            if (wordCounterMap.containsKey(tempString)) {
                wordIndexMap.put(i, tempString);
            }
        }
        // 检测连续的 k 个位置的单词是否和原来的单词计数相等
        Map<String, Long> counterMap = new HashMap<>(wordCounterMap.size());
        for (Map.Entry<Integer, String> entry : wordIndexMap.entrySet()) {
            counterMap.clear();
            counterMap.put(entry.getValue(), 1L);
            for (int i = 1; i < words.length; i++) {
                int j = entry.getKey() + wordLength * i;
                if (!wordIndexMap.containsKey(j)) {
                    break;
                } else {
                    counterMap.putIfAbsent(wordIndexMap.get(j), 0L);
                    counterMap.put(wordIndexMap.get(j), counterMap.get(wordIndexMap.get(j)) + 1L);
                }
            }
            if (mapMatch(wordCounterMap, counterMap)) {
                resultList.add(entry.getKey());
            }
        }
        return resultList;
    }

    /**
     * 判断两个 map 是否相等
     *
     * @param map1 map1
     * @param map2 map2
     * @return 是否相等
     */
    private <K, V> boolean mapMatch(Map<K, V> map1, Map<K, V> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map1.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}