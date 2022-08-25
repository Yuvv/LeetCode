import java.util.*;

/*
 * 0841-keys-and-rooms.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/25
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();

        List<Integer> curList = Arrays.asList(0);
        while (!curList.isEmpty()) {
            List<Integer> nl = new ArrayList<>();
            for (Integer key : curList) {
                if (keys.contains(key)) {
                    // already visit
                    continue;
                }
                List<Integer> itl = rooms.get(key);
                nl.addAll(itl);
            }
            keys.addAll(curList);
            curList = nl;
        }

        return keys.size() == rooms.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canVisitAllRooms(
            Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                new ArrayList<>(0)
            )
        ));
    }
}