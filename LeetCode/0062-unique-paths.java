class Solution {
    public int uniquePaths(int m, int n) {
        // C (m+n-2, n-1) 注意数值范围，cmn 会溢出
        
        return (int) c_m_n(m + n - 2, n - 1);
    }
    
    long c_m_n(int m, int n) {
       if (n == 0 || n == m) {
            return 1;
        }
        if (n > m / 2) {
            n = m - n;
        }

        long up = 1;
        long count = m - n + 1;
        while (count <= m) {
            up *= count;
            count++;
        }

        long down = 1;
        count = 2;
        while (count <= n) {
            down *= count;
            count++;
        }

        return up / down;
    }
}