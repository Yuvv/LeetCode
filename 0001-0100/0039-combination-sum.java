import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/*
 * 0039-combination-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/07/07
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        getCombinationSum(candidates, target, 0, new ArrayList<>(1), resultList);
        return resultList;
    }

    private void getCombinationSum(int[] candidates, int target, int fromIndex, List<Integer> currentList, List<List<Integer>> resultList) {
        for (int i = fromIndex; i < candidates.length; i++) {
            int val = candidates[i];
            // 注意每次循环都必须 new 一个新的 list 出来
            List<Integer> list = new ArrayList<>(currentList);
            list.add(val);
            // 递归循环查找目标数
            int nextTarget = target - val;
            if (nextTarget > 0) {
                // 每个数可用多次，每次都从 i 开始继续找，所以也不会重复
                getCombinationSum(candidates, nextTarget, i, list, resultList);
            } else if (nextTarget == 0) {
                resultList.add(list);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[] {2, 3, 6, 7};
        List<List<Integer>> result = s.combinationSum(arr, 7);
        // [[7],[2,2,3]]  expected
        System.out.println(result.toString());

        arr = new int[] {2, 3, 5};
        result = s.combinationSum(arr, 8);
        // [[2,2,2,2],[2,3,3],[3,5]]  expected
        System.out.println(result.toString());
    }
}
