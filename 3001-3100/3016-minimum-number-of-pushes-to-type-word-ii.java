import java.util.Arrays;

/**
 * 3016-minimum-number-of-pushes-to-type-word-ii.java
 *
 * @date 2024/2/2
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int minimumPushes(String word) {
        int[] cntArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            cntArr[word.charAt(i)-'a']++;
        }
        Arrays.sort(cntArr);
        int weight = 1;
        int cnt = 0;
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            if (cntArr[i] == 0) {
                break;
            }
            res += cntArr[i] * weight;
            cnt++;
            if (cnt == 8) {
                cnt = 0;
                weight++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minimumPushes("abcde"));
        // 12
        System.out.println(s.minimumPushes("xycdefghij"));
    }
}
