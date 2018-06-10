// 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // 组合方式，WA
        // int k=1;
        // int sum = 1;
        // while(n >= 2*k) {
        //     sum += C(k, n-k);
        //     k += 1;
        // }
        // return sum;
        
        // 递归方法解动态规划，TLE
        // if(n < 4 && n > 0) {
        //     return n;
        // } else {
        //     return climbStairs(n-1) + climbStairs(n-2);
        // }
        
        // 非递归动态规划，AC
        // int[] stairs = new int[100000];
        // stairs[0] = 0;
        // stairs[1] = 1;
        // stairs[2] = 2;
        
        // if (n < 3) {
        //     return stairs[n];
        // }
        // for(int i=3; i<=n; i++) {
        //     stairs[i] = stairs[i-1] + stairs[i-2];
        // }
        // return stairs[n];
        
        // 优化非递归动态规划
        int n_1 = 2;    // f(n-1)
        int n_2 = 1;    // f(n-2)
        int result = 0;
        
        if(n<3) {
            return n;
        }
        for(int i=3; i<=n; i++) {
            result = n_1 + n_2;
            n_2 = n_1;
            n_1 = result;
        }
        return result;
    }
    
    // int C(int k, int n) {
    //     int sK = 1;
    //     int sN = 1;
        
    //     int i;
        
    //     i=1;
    //     while(i<=k) {
    //         sK *= i;
    //         i++;
    //     }
    //     i=n-k+1;
    //     while(i<=n) {
    //         sN *= i;
    //         i++;
    //     }
        
    //     return sN/sK;
    // }
}