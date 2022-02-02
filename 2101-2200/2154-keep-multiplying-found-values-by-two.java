import java.util.Set;
import java.util.HashSet;

/*
 * 2154-keep-multiplying-found-values-by-two.java
 *
 * @author yuweiwei7 <yuweiwei3@jd.com>
 * @date 2022/02/02
 */
public class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            set.add(n);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 24
        System.out.println(s.findFinalValue(new int[] {5,3,6,1,12}, 3));
    }
}