public class Solution {
    /**
     * @param n: a positive integer
     * @param primes: the given prime list
     * @return: the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] vals = new int[n];
        vals[0] = 1;

        int[] primeIndexes = new int[primes.length];
        int[] primeTempVals = new int[primes.length];

        int curIdx = 1;
        int minVal;

        while (curIdx < n) {
            for (int i = 0; i < primes.length; i++) {
                primeTempVals[i] = primes[i] * vals[primeIndexes[i]];
            }

            minVal = getMinVal(primeTempVals);

            for (int i = 0; i < primes.length; i++) {
                if (primeTempVals[i] == minVal) {
                    primeIndexes[i]++;
                }
            }

            vals[curIdx] = minVal;
            curIdx++;
        }

        return vals[n - 1];
        
    }
    
    int getMinVal(int[] vals) {
        int curMin = Integer.MAX_VALUE;
        for (int val: vals) {
            if (val < curMin) {
                curMin = val;
            }
        }
        return curMin;
    }
}