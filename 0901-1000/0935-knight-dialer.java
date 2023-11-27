import java.util.Arrays;

/**
 * 0935-knight-dialer
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/27
 */
public class Solution {
    public static final int[][] NEXT = new int[][] {
            { 4, 6 }, // 0
            { 6, 8 }, // 1
            { 7, 9 }, // 2
            { 4, 8 }, // 3
            { 0, 3, 9 }, // 4
            {}, // 5
            { 0, 1, 7 }, // 6
            { 2, 6 }, // 7
            { 1, 3 }, // 8
            { 2, 4 } // 9
    };
    public static final long MOD = 1000000007L;

    public int knightDialer(int n) {
        long[] table = new long[] {1,1,1,1,1,1,1,1,1,1};
        long[] st = new long[table.length];
        while (n > 1) {
            Arrays.fill(st, 0L);
            for (int i = 0; i < 10; i++) {
                for (int j : NEXT[i]) {
                    st[i] += table[j];
                    st[i] %= MOD;
                }
            }
            for (int i = 0; i < 10; i++) {
                table[i] = st[i];
            }
            n--;
        }

        long res = 0L;
        for (long e : table) {
            res += e;
            res %= MOD;
        }

        return (int) res;
    }

    private long dfs(int[] candidate, int n) {
        if (n == 1) {
            return candidate.length;
        }
        long res = 0L;
        for (int next : candidate) {
            res += dfs(NEXT[next], n - 1);
            res %= MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.knightDialer(1));
        // 20
        System.out.println(s.knightDialer(2));
        // 46
        System.out.println(s.knightDialer(3));
        // 104
        System.out.println(s.knightDialer(4));
        // 136006590
        System.out.println(s.knightDialer(3131));
    }
}
