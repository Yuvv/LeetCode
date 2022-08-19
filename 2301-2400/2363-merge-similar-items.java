import java.util.*;

/*
 * 2363-merge-similar-items.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/20
 */
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        List<List<Integer>> resList = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            resList.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        resList.sort(Comparator.comparingInt(l -> l.get(0)));
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,6],[3,9],[4,5]]
        System.out.println(s.mergeSimilarItems(
            new int[][] {{1,1}, {4,5}, {3,8}},
            new int[][] {{3,1}, {1,5}}
        ));
    }
}