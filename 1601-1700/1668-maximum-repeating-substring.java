/*
 * 1668-maximum-repeating-substring.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/28
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int fromIdx = 0;
        while (fromIdx >= 0 && fromIdx < sequence.length()) {
            fromIdx = sequence.indexOf(word, fromIdx);
            if (fromIdx >= 0) {
                int cnt = 1;
                int i = fromIdx + word.length();
                while (sequence.indexOf(word, i) == i) {
                    cnt += 1;
                    i += word.length();
                }
                max = Math.max(max, cnt);

                fromIdx++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxRepeating("ababc", "ab"));
        // 1
        System.out.println(s.maxRepeating("ababc", "ba"));
        // 0
        System.out.println(s.maxRepeating("ababc", "ac"));
    }
}