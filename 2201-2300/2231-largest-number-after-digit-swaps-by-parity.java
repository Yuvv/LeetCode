import java.util.*;

/*
 * 2231-largest-number-after-digit-swaps-by-parity.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/27
 */
public class Solution {
    public int largestInteger(int num) {
        List<Integer> oddNums = new ArrayList<>();
        List<Integer> oddIdxs = new ArrayList<>();
        List<Integer> evenNums = new ArrayList<>();
        List<Integer> evenIdxs = new ArrayList<>();
        int i = 0;
        while (num > 0) {
            int val = num % 10;
            if (val % 2 == 0) {
                evenNums.add(val);
                evenIdxs.add(i);
            } else {
                oddNums.add(val);
                oddIdxs.add(i);
            }
            num /= 10;
            i++;
        }

        Collections.sort(oddNums, Comparator.naturalOrder());
        Collections.sort(evenNums, Comparator.naturalOrder());
        int[] nums = new int[i];
        for (int j = 0; j < oddIdxs.size(); j++) {
            nums[i - 1 - oddIdxs.get(j)] = oddNums.get(j);
        }
        for (int j = 0; j < evenIdxs.size(); j++) {
            nums[i - 1 - evenIdxs.get(j)] = evenNums.get(j);
        }
        int res = 0;
        for (int e : nums) {
            res = res * 10 + e;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3412
        System.out.println(s.largestInteger(1234));
        // 87655
        System.out.println(s.largestInteger(65875));
    }
}