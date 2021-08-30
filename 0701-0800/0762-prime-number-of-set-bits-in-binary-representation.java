import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/*
 * 0762-prime-number-of-set-bits-in-binary-representation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/30
 */
public class Solution {
    Set<Integer> primeCache;

    public boolean isPrime(int val) {
        if (primeCache.contains(val)) {
            return true;
        }
        boolean isP = val >= 2;
        for (int i = 2; i <= (int) Math.sqrt(val); i++) {
            if (val % i == 0) {
                isP = false;
                break;
            }
        }
        if (isP) {
            primeCache.add(val);
        }

        return isP;
    }

    public int countPrimeSetBits(int left, int right) {
        primeCache = new HashSet<>();
        Map<Integer, Integer> bin1countCache = new HashMap<>();
        int totalCount = 0;

        while (left <= right) {
            int bin1count;
            if (bin1countCache.containsKey(left)) {
                bin1count = bin1countCache.get(left);
            } else {
                int val = left;
                bin1count = 0;
                while (val > 0) {
                    if (bin1countCache.containsKey(val)) {
                        bin1count += bin1countCache.get(val);
                        val = 0;
                    } else {
                        bin1count += val & 0x01;
                        val >>= 1;
                    }
                }
                bin1countCache.put(left, bin1count);
                // check if is prime
                if (isPrime(bin1count)) {
                    totalCount += 1;
                }
            }

            left++;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countPrimeSetBits(6, 10));
        // 5
        System.out.println(s.countPrimeSetBits(10, 15));
        // 3478
        System.out.println(s.countPrimeSetBits(1230, 9654));
    }
}