import java.util.*;
import java.util.stream.Collectors;

/*
 * 2248-intersection-of-multiple-arrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/01
 */
public class Solution {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < nums[0].length; i++) {
            intersection.add(nums[0][i]);
        }
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int each : nums[i]) {
                if (intersection.contains(each)) {
                    set.add(each);
                }
            }
            intersection = set;
        }
        return intersection.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,4]
        System.out.println(s.intersection(
            new int[][] {
                {3,1,2,4,5},
                {1,2,3,4},
                {3,4,5,6}
            }
        ));
        // []
        System.out.println(s.intersection(
            new int[][] {
                {1,2,3},
                {4,5,6}
            }
        ));
    }
}