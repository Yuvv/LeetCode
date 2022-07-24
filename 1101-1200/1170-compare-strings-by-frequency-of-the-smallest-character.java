/*
 * 1170-compare-strings-by-frequency-of-the-smallest-character.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/24
 */
public class Solution {

    private int getFrequency(String word) {
        int cnt = 0;
        char smallCh = (char)127;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            if (ch < smallCh) {
                cnt = 1;
                smallCh = ch;
            } else if (ch == smallCh) {
                cnt++;
            }
        }
        return cnt;
    }

    private int bFindTargetLtCount(int[] frequency, int target) {
        int i = 0;
        int j = frequency.length - 1;
        if (target < frequency[i]) {
            return frequency.length;
        }
        if (target > frequency[j]) {
            return 0;
        }
        // find first lt index
        while (i <= j) {
            int mid = (i + j) / 2;
            if (frequency[mid] > target) {
                j = mid - 1;
            } else if (frequency[mid] <= target) {
                i = mid + 1;
            }
        }
        return frequency.length - i;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] frequency = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            frequency[i] = getFrequency(words[i]);
        }
        java.util.Arrays.sort(frequency);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int freq = getFrequency(queries[i]);

            res[i] = bFindTargetLtCount(frequency, freq);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1]
        System.out.println(java.util.Arrays.toString(
            s.numSmallerByFrequency(
                new String[]{"cbd"}, new String[] {"zaaaz"}
        )));
        // [1,2,3,0,0]
        System.out.println(java.util.Arrays.toString(
            s.numSmallerByFrequency(
                new String[] {"bbb", "cc", "d", "dddd", "dddddddd"},
                new String[] {"a", "aa", "aaa", "aaaa"}
        )));
    }
}