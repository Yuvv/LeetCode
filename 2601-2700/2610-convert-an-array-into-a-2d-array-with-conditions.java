import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 2610-convert-an-array-into-a-2d-array-with-conditions
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/1/2
 */
public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> lst = new ArrayList<>(map.keySet());
            for (Integer e : lst) {
                Integer v = map.get(e);
                if (v == null || v <= 1) {
                    map.remove(e);
                } else {
                    map.put(e, v - 1);
                }
            }
            res.add(lst);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,3,4,2],[1,3],[1]]
        System.out.println(s.findMatrix(new int[] { 1, 3, 4, 1, 2, 3, 1 }));
        // [[1,3,4,2]]
        System.out.println(s.findMatrix(new int[] { 1, 3, 4, 2 }));
    }
}
