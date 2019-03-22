import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    /**
     * 找出两个句子中不同的单词
     * https://leetcode.com/problems/uncommon-words-from-two-sentences/
     *
     * @param A 句子1
     * @param B 句子2
     * @return 不同的单词
     */
    public String[] uncommonFromSentences(String A, String B) {
        String[] aSentence = A.split(" ");
        String[] bSentence = B.split(" ");

        List<String> words = Stream.of(aSentence, bSentence)
            .flatMap(Stream::of)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .filter(x -> x.getValue().equals(1L))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        String[] result = new String[words.size()];
        words.toArray(result);
        return result;
    }
}