import java.util.Arrays;

/*
 * 0948-bag-of-tokens.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/05
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if (tokens.length == 0 || tokens[0] > power) {
            return 0;
        }
        int maxScore = 0;
        int score = 0;
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            while (i <= j && power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
            }
            maxScore = Math.max(score, maxScore);
            if (i <= j) {
                power += tokens[j];
                j--;
                score--;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.bagOfTokensScore(new int[] {100}, 50));
        // 1
        System.out.println(s.bagOfTokensScore(new int[] {100,200}, 150));
        // 2
        System.out.println(s.bagOfTokensScore(new int[] {100,200,300,400}, 200));
        // 0
        System.out.println(s.bagOfTokensScore(new int[] {71,55,82}, 54));
    }
}