import java.util.*;
import java.util.stream.Collectors;

/*
 * 0077-combinations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/03/21
 */
public class Solution {
    /**
     * just get n-nums subsets and filter subset with size of k
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(0));

        // iteration
        for (int num = 1; num <= n; num++) {
            int lastSize = result.size();
            for (int i = 0; i < lastSize; i++) {
                List<Integer> thatList = result.get(i);
                if (thatList.size() >= k) {
                    continue;
                }
                List<Integer> curList = new ArrayList<>(thatList);
                curList.add(num);
                result.add(curList);
            }
        }

        return result.stream().filter(l -> l.size() == k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
        System.out.println(s.combine(4, 2));
        // [[1]]
        System.out.println(s.combine(1, 1));
    }
}