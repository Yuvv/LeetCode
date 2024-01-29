import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1177-can-make-palindrome-from-substring.java
 *
 * @date 2024/1/29
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] prefixSum = new int[s.length()+1][];
        prefixSum[0] = new int[26];
        for (int i = 1; i <= s.length(); i++) {
            prefixSum[i] = Arrays.copyOf(prefixSum[i-1], 26);
            prefixSum[i][s.charAt(i-1)-'a']++;
        }
        List<Boolean> resList = new ArrayList<>();
        for (int[] query : queries) {
            int cnt = 0;
            int[] lSum = prefixSum[query[0]];
            int[] rSum = prefixSum[query[1]+1];
            for (int i = 0; i < 26; i++) {
                if ((rSum[i]-lSum[i]) % 2 > 0) {
                    cnt++;
                }
            }
            resList.add(cnt/2 <= query[2]);
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [true,false,false,true,ture]
        System.out.println(s.canMakePaliQueries(
                "abcda",
                new int[][] { { 3, 3, 0 }, { 1, 2, 0 }, { 0, 3, 1 }, { 0, 3, 2 }, { 0, 4, 1 } }));
        // [false,true]
        System.out.println(s.canMakePaliQueries(
                "abcda",
                new int[][] { {0,1,0}, { 2, 2, 1 } }));
        
    }
}
