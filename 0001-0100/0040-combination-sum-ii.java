import java.util.*;

/*
 * 0040-combination-sum-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/07/28
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序，以便后面去重
        Arrays.sort(candidates);
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
            int nextTarget = target - val;
            if (nextTarget > 0) {
                getCombinationSum(candidates, nextTarget, i + 1, list, resultList);
            } else if (nextTarget == 0) {
                resultList.add(list);
            }

            // 有相同的数则跳过，前面已经做过一次了
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[] {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = s.combinationSum2(arr, 8);
        // [[1,7], [1,2], [2,6], [1,1,6]]  expected
        System.out.println(result.toString());

        arr = new int[] {2, 5, 2, 1, 2};
        result = s.combinationSum2(arr, 5);
        // [[1,2,2], [5]]  expected
        System.out.println(result.toString());

        arr = new int[] {10, 1, 2, 7, 6, 1, 2, 3, 4, 1, 5};
        result = s.combinationSum2(arr, 8);
        // [[1,1,1,2,3], [1,1,1,5], [1,1,2,4], [1,1,6], [1,2,2,3], [1,2,5], [1,3,4], [1,7], [2,2,4], [2,6], [3,5]]  expected
        System.out.println(result.toString());
    }
}