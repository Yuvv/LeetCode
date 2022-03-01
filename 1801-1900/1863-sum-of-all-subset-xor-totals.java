import java.util.*;

/*
 * 1863-sum-of-all-subset-xor-totals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/02
 */
public class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0));
        for (int num : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> ll = new ArrayList<>(list.get(i));
                ll.add(num);
                ll.set(0, ll.get(0) ^ num);
                sum += ll.get(0);
                list.add(ll);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.subsetXORSum(new int[] {1, 3}));
        //28
        System.out.println(s.subsetXORSum(new int[] {5, 1, 6}));

    }
}