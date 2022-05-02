import java.util.*;

/*
 * 2164-sort-even-and-odd-indices-independently.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/02
 */
public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odds = new ArrayList<>(nums.length / 2 + 1);
        List<Integer> evens = new ArrayList<>(nums.length / 2 + 1);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }
        odds.sort(Comparator.reverseOrder());
        evens.sort(Comparator.naturalOrder());
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            nums[k] = evens.get(i++);
            k++;
            if (k < nums.length && j < odds.size()) {
                nums[k] = odds.get(j++);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3,4,1]
        System.out.println(s.sortEvenOdd(new int[] {4,1,2,3}));
    }
}