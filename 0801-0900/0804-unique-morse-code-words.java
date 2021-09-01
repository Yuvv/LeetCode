import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

/*
 * 0804-unique-morse-code-words.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/01
 */
public class Solution {

    private String[] MORSE = new String[] {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."
        };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String morse = word.chars()
                    .mapToObj(c -> MORSE[c - 'a'])
                    .collect(Collectors.joining());
            set.add(morse);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.uniqueMorseRepresentations(new String[] {"gin","zen","gig","msg"}));
        // 1
        System.out.println(s.uniqueMorseRepresentations(new String[] {"a"}));
    }
}