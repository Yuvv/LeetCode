import java.util.Set;
import java.util.HashSet;

/**
 * 2568-minimum-impossible-or
 *
 * @author Yuvv <yuvv_th@oulook.com>
 * @date 2023/12/03
 */
public class Solution {
    public int minImpossibleOR(int[] nums) {
        // The minimum power of 2 not present in the array will be the first number 
        // that could not be expressed using the given operation.
        Set<Integer> p2set = new HashSet<>();
        int val = 1;
        for (int i =0; i < 30; i++) {
            p2set.add(val << i);
        }
        for (int n : nums) {
            p2set.remove(n);
        }
        return p2set.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.minImpossibleOR(new int[] {1,2}));
        // 1
        System.out.println(s.minImpossibleOR(new int[] {5,3,2}));
    }
}
