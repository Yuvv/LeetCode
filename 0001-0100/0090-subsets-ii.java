import java.util.*;

/*
 * 0090-subsets-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/03/21
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(0));

        // sorted is needed
        Arrays.sort(nums);
        // store duplicated number's last result size
        Map<Integer, Integer> numSizeMap = new HashMap<>();
        // iteration
        for (int num : nums) {
            int lastSize = result.size();
            int beginSize = numSizeMap.getOrDefault(num, 0);
            for (int i = beginSize; i < lastSize; i++) {
                List<Integer> curList = new ArrayList<>(result.get(i));
                curList.add(num);
                result.add(curList);
            }
            numSizeMap.put(num, lastSize);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> result = s.subsetsWithDup(new int[] {1, 2, 2});
        // [[],[1],[1,2],[1,2,2],[2],[2,2]]   expected
        System.out.println(result);

        result = s.subsetsWithDup(new int[] {1});
        // [[],[1]]   expected
        System.out.println(result);
    }
}