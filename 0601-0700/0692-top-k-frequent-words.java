import java.util.*;

/*
 * 0692-top-k-frequent-words.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/11/13
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // build word count map
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String w : words) {
            wordCountMap.put(w, wordCountMap.getOrDefault(w, 0) + 1);
        }
        // build count map of all words
        TreeMap<Integer, TreeSet<String>> countWordMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            countWordMap.computeIfAbsent(entry.getValue(), c -> new TreeSet<>()).add(entry.getKey());
        }
        // iterate
        List<String> result = new ArrayList<>(k);
        while (k > 0 && !countWordMap.isEmpty()) {
            Map.Entry<Integer, TreeSet<String>> entry = countWordMap.pollLastEntry();
            Iterator<String> wordSetIt = entry.getValue().iterator();
            while (k > 0 && wordSetIt.hasNext()) {
                k--;
                result.add(wordSetIt.next());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["i", "love"]   expected
        System.out.println(s.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        //["the", "is", "sunny", "day"]   expected
        System.out.println(s.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
