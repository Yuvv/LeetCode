import java.util.*;

/*
 * 2785-sort-vowels-in-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/09/02
 */
public class Solution {
    public String sortVowels(String s) {
        String vowels = "AEIOUaeiou";  // increasing order
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < vowels.length(); i++) {
            map.put(vowels.charAt(i), 0);
        }
        List<Integer> indexList = new ArrayList<>();
        char[] schars = s.toCharArray();
        for (int i = 0; i < schars.length; i++) {
            if (map.containsKey(schars[i])) {
                indexList.add(i);
                map.put(schars[i], map.get(schars[i])+1);
            }
        }

        int k = 0;
        for (int i = 0; i < vowels.length(); i++) {
            for (int j = 0; j < map.get(vowels.charAt(i)); j++) {
                schars[indexList.get(k)] = vowels.charAt(i);
                k++;
            }
        }
        return new String(schars);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "lEOtcede"
        System.out.println(s.sortVowels("lEetcOde"));
        // "lYmpH"
        System.out.println(s.sortVowels("lYmpH"));
    }
}