import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * 2761-prime-pairs-with-target-sum.java
 *
 * @date 2024/1/22
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {

    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 2; i <= n/2; i++) {
            if (!notPrime[i] && !notPrime[n-i]) {
                resList.add(Arrays.asList(i, n-i));
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,7],[5,5]]
        System.out.println(s.findPrimePairs(10));
        // []
        System.out.println(s.findPrimePairs(2));
    }
}
