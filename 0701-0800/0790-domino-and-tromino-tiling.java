import java.util.Map;
import java.util.HashMap;

import java.util.Map;
import java.util.HashMap;

/*
 * 0790-domino-and-tromino-tiling.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/10
 */
public class Solution {
    private Map<Integer, Integer> fCacheMap = new HashMap<>();
    private Map<Integer, Integer> pCacheMap = new HashMap<>();
    private int mod = 1000000007;

    // init
    {
        fCacheMap.put(1, 1);
        fCacheMap.put(2, 2);
        pCacheMap.put(1, 0);
        pCacheMap.put(2, 2);
    }

    public int numTilings(int n) {
        // f(k) = number of ways to fully cover a board of withd k
        // p(k) = number of ways to partially cover a board of withd k
        // f(k+1) = f(k) + f(k-1) + p(k)
        // p(k+1) = 2f(k-1) + p(k)
        for (int i = 3; i <= n; i++) {
            int pk = 2 * fCacheMap.get(i - 2) - mod + pCacheMap.get(i - 1);
            if (pk < mod) {
                pk += mod;
            }
            pCacheMap.put(i, pk % mod);
            int fk = fCacheMap.get(i - 1) - mod + fCacheMap.get(i - 2) + pCacheMap.get(i - 1);
            if (fk < mod) {
                fk += mod;
            }
            fCacheMap.put(i, fk % mod);
        }

        return fCacheMap.get(n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numTilings(1));
        // 5
        System.out.println(s.numTilings(3));
        // 190242381
        System.out.println(s.numTilings(100));
        // 451995198
        System.out.println(s.numTilings(50));
        // 979232805
        System.out.println(s.numTilings(1000));

        // others
        for (int j = 0; j < args.length; j++) {
            System.out.println(s.numTilings(Integer.parseInt(args[j])));
        }
    }
}