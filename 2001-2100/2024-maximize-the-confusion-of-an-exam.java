/*
 * 2024-maximize-the-confusion-of-an-exam.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/29
 */
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0;
        int i = 0, j = 0;
        int fc = 0, tc = 0;
        for (j = 0; j < answerKey.length(); j++) {
            if (answerKey.charAt(j) == 'T') {
                tc++;
            } else {
                fc++;
            }
            if (fc > k && tc > k) {
                if (answerKey.charAt(i) == 'T') {
                    tc--;
                } else {
                    fc--;
                }
                i++;
            }
            max = Math.max(max, fc + tc);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxConsecutiveAnswers("TTFF", 2));
        // 3
        System.out.println(s.maxConsecutiveAnswers("TFFT", 1));
        // 5
        System.out.println(s.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}