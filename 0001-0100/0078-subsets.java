import java.util.*;


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(0));

        // iteration
        for (int num : nums) {
            int lastSize = result.size();
            for (int i = 0; i < lastSize; i++) {
                List<Integer> curList = new ArrayList<>(result.get(i));
                curList.add(num);
                result.add(curList);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> result = s.subsets(new int[] {1, 2, 3});
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]   expected
        System.out.println(result);

        result = s.subsets(new int[] {1});
        // [[],[1]]   expected
        System.out.println(result);
    }
}