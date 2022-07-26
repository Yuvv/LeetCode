import java.util.*;
import java.util.stream.Collectors;

/*
 * 2225-find-players-with-zero-or-one-losses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/26
 */
public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winnerSet = new HashSet<>();
        Map<Integer, Integer> losserMap = new HashMap<>();
        for (int[] pair : matches) {
            winnerSet.add(pair[0]);
            losserMap.put(pair[1], losserMap.getOrDefault(pair[1], 0) + 1);
        }
        List<Integer> lossers = losserMap.entrySet().stream()
                .peek(e -> winnerSet.remove(e.getKey()))
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> winners = winnerSet.stream()
                .sorted()
                .collect(Collectors.toList());
        return Arrays.asList(winners, lossers);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2,10],[4,5,7,8]]
        System.out.println(s.findWinners(new int[][] {
            {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}
        }));
    }
}