/**
 * 2559-count-vowel-strings-in-ranges.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/08
 */
public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length+1];
        for (int i = 0; i < words.length; i++) {
            char ch0 = words[i].charAt(0);
            char chn = words[i].charAt(words[i].length()-1);
            if (ch0 == 'a' || ch0 == 'e' || ch0 == 'i' || ch0 == 'o' || ch0 == 'u') {
                if (chn == 'a' || chn == 'e' || chn == 'i' || chn == 'o' || chn == 'u') {
                    prefixSum[i+1] = prefixSum[i] + 1;
                } else {
                    prefixSum[i+1] = prefixSum[i];
                }
            } else {
                prefixSum[i+1] = prefixSum[i];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefixSum[queries[i][1]+1] - prefixSum[queries[i][0]];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3,0]
        System.out.println(java.util.Arrays.toString(s.vowelStrings(
            new String[] {"aba", "bcb", "ece", "aa", "e"},
            new int[][] {{0,2}, {1,4}, {1,1}}
        )));
    }
}
