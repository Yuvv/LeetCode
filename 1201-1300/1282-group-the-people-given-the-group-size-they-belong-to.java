import java.util.*;

/*
 * 1282-group-the-people-given-the-group-size-they-belong-to.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/28
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int gs = groupSizes[i];
            List<Integer> list = map.computeIfAbsent(gs, k -> new ArrayList<>());
            list.add(i);
            if (list.size() == gs) {
                map.remove(gs);
                resultList.add(list);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[5],[0,1,2],[3,4,6]]
        System.out.println(s.groupThePeople(new int[] {3,3,3,3,3,1,3}));
        // [[1],[0,5],[2,3,4]]
        System.out.println(s.groupThePeople(new int[] {2,1,3,3,3,2}));
    }
}