import java.util.*;
/**
 * 1557-minimum-number-of-vertices-to-reach-all-nodes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/10
 */
public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] ind = new int[n];
        for (List<Integer> ed : edges) {
            ind[ed.get(1)]++;
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                resList.add(i);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,3]
        System.out.println(s.findSmallestSetOfVertices(
            6, Arrays.asList(Arrays.asList(0,1), Arrays.asList(0,2), Arrays.asList(2,5), Arrays.asList(3,4), Arrays.asList(4,2))
        ));
    }
}
