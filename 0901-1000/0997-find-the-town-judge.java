/*
 * 997-find-the-town-judge.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/22
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] tn = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int[] ab : trust) {
            tn[ab[1]]++;
            visited[ab[0]] = true;
        }
        int count = 0;
        int findIdx = 0;
        for (int i = 1; i <= n; i++) {
            if (tn[i] == n - 1) {
                count++;
                findIdx = i;
            }
        }
        if (count == 1 && !visited[findIdx]) {
            return findIdx;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findJudge(2, new int[][] {{1,2}}));
        // 3
        System.out.println(s.findJudge(3, new int[][] {{1,3}, {2,3}}));
        // -1
        System.out.println(s.findJudge(3, new int[][] {{1,3}, {2,3}, {3,1}}));
    }
}