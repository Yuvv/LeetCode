import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * 2709-greatest-common-divisor-traversal.java
 *
 * @date 2024/2/25
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int MAX = nums[0];
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
            MAX = Math.max(MAX, num);
        }
        // get min-factor for numbers from 2 to MAX
        int[] factors = new int[MAX+1];
        for (int i = 0; i <= MAX; i++) {
            factors[i] = i;
        }
        for (int i = 2; i <= MAX; i++) {
            for (int j = i*2; j <= MAX; j += i) {
                if (factors[j] <= i) {
                    continue;
                }
                factors[j] = i;
            }
        }

        // set min-factor for every num
        int[] groups = new int[MAX+1];
        for (int i = 1; i < groups.length; i++) {
            groups[i] = i;
        }
        for (int num : nums) {
            List<Integer> nList = new ArrayList<>();
            int minGroup = groups[num];
            while (num > 1) {
                int factor = factors[num];
                nList.add(num);
                if (num != factor) {
                    nList.add(factor);
                }
                minGroup = Math.min(minGroup, groups[factor]);
                while (num % factor == 0) {
                    num /= factor;
                }
            }
            // merge
            for (Integer n : nList) {
                while (groups[n] != minGroup) {
                    int origin = groups[n];
                    groups[n] = minGroup;
                    n = origin;
                }
            }
        }

        // get real group and check the result
        int group = nums[0];
        while (group != groups[group]) {
            group = groups[group];
        }
        for (int i = 1; i < nums.length; i++) {
            int cg = nums[i];
            while (cg != groups[cg]) {
                cg = groups[cg];
            }
            if (cg != group) {
                return false;
            }
            groups[nums[i]] = group;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canTraverseAllPairs(new int[]{2,3,6}));
        // false
        System.out.println(s.canTraverseAllPairs(new int[]{3,9,5}));
        // true
        System.out.println(s.canTraverseAllPairs(new int[]{4,3,12,8}));
    }
}

