import java.util.*;

/*
 * 2442-count-number-of-distinct-integers-after-reverse-operations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/15
 */
public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            // add this will be wrong, though, i don't known why
            // if (set.contains(n)) {
            //     continue;
            // }
            set.add(n);
            int m = 0;
            while (n > 0) {
                m = m * 10 + n % 10;
                n /= 10;
            }
            set.add(m);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countDistinctIntegers(
            new int[] {1,13,10,12,31}
        ));
    }
}