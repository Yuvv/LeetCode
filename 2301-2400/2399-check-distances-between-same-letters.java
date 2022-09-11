/*
 * 2399-check-distances-between-same-letters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/12
 */
public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        boolean[] visit = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (visit[idx]) {
                continue;
            }
            int nextIdx = i + distance[idx] + 1;
            if (nextIdx >= s.length() || s.charAt(nextIdx) != ch) {
                return false;
            }
            visit[idx] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkDistances(
            "abaccb",
             new int[] {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        ));
    }
}