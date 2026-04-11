import java.util.*;
/**
 * 1255-maximum-score-words-formed-by-letters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/04/11
 */
public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] wordScores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int wordScore = 0;
            for (char c : words[i].toCharArray()) {
                wordScore += score[c - 'a'];
            }
            wordScores[i] = wordScore;
        }
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return backtrack(words, wordScores, letterCount, 0);
    }

    private int backtrack(String[] words, int[] wordScores, int[] letterCount, int index) {
        if (index == words.length) {
            return 0;
        }
        // skip current word
        int maxScore = backtrack(words, wordScores, letterCount, index + 1);
        // try to use current word
        String word = words[index];
        int wi = 0;
        while (wi < word.length()) {
            char c = word.charAt(wi);
            int lc = letterCount[c - 'a'];
            if (lc <= 0) {
                wi--;
                break; // cannot use this word
            }
            letterCount[c - 'a']--; // use this letter
            wi++;
        }
        if (wi == word.length()) {
            maxScore = Math.max(maxScore, wordScores[index] + backtrack(words, wordScores, letterCount, index + 1));
            wi--;
        }
        // restore letters
        while (wi >= 0) {
            char c = word.charAt(wi);
            letterCount[c - 'a']++;
            wi--;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 23
        System.out.println(s.maxScoreWords(
            new String[]{"dog","cat","dad","good"},
            new char[]{'a','a','c','d','d','d','g','o','o'},
            new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}
        ));
        // 27
        System.out.println(s.maxScoreWords(
            new String[]{"xxxz","ax","bx","cx"},
            new char[]{'z','a','b','c','x','x','x'},
            new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10}
        ));
        // 0
        System.out.println(s.maxScoreWords(
            new String[]{"leetcode"},
            new char[]{'l','e','t','c','o','d'},
            new int[]{0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        ));
    }
}