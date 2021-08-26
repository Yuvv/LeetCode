import java.util.*;

/*
 * 0436-find-right-interval.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/25
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        List<AbstractMap.SimpleImmutableEntry<Integer, Boolean>> entryList = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Set<Integer>> endIndexMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            entryList.add(new AbstractMap.SimpleImmutableEntry<>(intervals[i][0], true));
            entryList.add(new AbstractMap.SimpleImmutableEntry<>(intervals[i][1], false));
            indexMap.put(intervals[i][0], i);
            endIndexMap.computeIfAbsent(intervals[i][1], k -> new HashSet<>()).add(i);
        }
        // sort by start&end index
        entryList.sort(new Comparator<AbstractMap.SimpleImmutableEntry<Integer, Boolean>>() {
            @Override
            public int compare(AbstractMap.SimpleImmutableEntry<Integer, Boolean> o1, AbstractMap.SimpleImmutableEntry<Integer, Boolean> o2) {
                int r = o1.getKey().compareTo(o2.getKey());
                if (r == 0) {
                    // end_i < begin_j
                    if (o1.getValue() && !o2.getValue()) {
                        r = 1;
                    } else if (!o1.getValue() && o2.getValue()) {
                        r = -1;
                    }
                }
                return r;
            }
        });
        Set<Integer> toSetIndex = new HashSet<>();
        for (Map.Entry<Integer, Boolean> entry : entryList) {
            if (entry.getValue()) {
                for (Integer idx : toSetIndex) {
                    result[idx] = indexMap.get(entry.getKey());
                }
                toSetIndex.clear();
            } else {
                toSetIndex.addAll(endIndexMap.get(entry.getKey()));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [-1,2,-1]
        System.out.println(Arrays.toString(s.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
        // [-1,0,1]
        System.out.println(Arrays.toString(s.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
        // [-1]
        System.out.println(Arrays.toString(s.findRightInterval(new int[][]{{-1, 2}})));
    }
}