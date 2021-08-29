import java.util.Map;
import java.util.HashMap;

/*
 * 0748-shortest-completing-word.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/29
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            if (c >= 'a' && c <= 'z') {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
        }

        int shortestLen = 100000000;
        String shortestStr = null;
        for (String word : words) {
            word = word.toLowerCase();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            boolean ok = true;
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                Integer count = map.get(entry.getKey());
                if (count == null || count < entry.getValue()) {
                    ok = false;
                    break;
                }
            }
            if (ok && word.length() < shortestLen) {
                shortestLen = word.length();
                shortestStr = word;
            }
        }
        return shortestStr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "steps"
        System.out.println(s.shortestCompletingWord("1s3 PSt", new String[] {"step","steps","stripe","stepple"}));
        // "pest"
        System.out.println(s.shortestCompletingWord("1s3 456", new String[] {"looks","pest","stew","show"}));
        // "husband"
        System.out.println(s.shortestCompletingWord("Ah71752", new String[] {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"}));
    }
}