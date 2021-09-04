import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/*
 * 0824-goat-latin.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/04
 */
public class Solution {
    private Set<Character> VOWEL = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String toAppend = "a";
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (VOWEL.contains(word.charAt(0))) {
                sb.append(word).append("ma").append(toAppend).append(' ');
            } else {
                sb.append(word.substring(1)).append(word.charAt(0)).append("ma").append(toAppend).append(' ');
            }
            toAppend += 'a';
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println(s.toGoatLatin("I speak Goat Latin"));
        // "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
        System.out.println(s.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}