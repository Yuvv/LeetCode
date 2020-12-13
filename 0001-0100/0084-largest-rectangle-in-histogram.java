import java.util.*;

/*
 * 0084-largest-rectangle-in-histogram.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/12/13
 */
public class Solution {
    /**
     * TLE 😭
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Set<Integer> viewedSet = new TreeSet<>();
        Map<Integer, List<Integer>> continuesIdxMap = new HashMap<>();
        // 找连续递增区间
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            List<Integer> idxRange = continuesIdxMap.computeIfAbsent(heights[i], k -> new ArrayList<>());
            if (idxRange.isEmpty()) {
                idxRange.add(i);
                idxRange.add(i);
            } else {
                if (i - idxRange.get(1) == 1) {
                    idxRange.set(1, i);
                } else {
                    maxArea = Math.max(maxArea, heights[i] * (idxRange.get(1) - idxRange.get(0) + 1));
                    idxRange.set(0, i);
                    idxRange.set(1, i);
                }
            }
            // 回溯走过的位置
            for (Integer vi : viewedSet) {
                List<Integer> viIdxRange = continuesIdxMap.get(vi);
                if (vi <= heights[i]) {
                    if (i - viIdxRange.get(1) <= 1) {
                        // 包括差一个和刚好是自己的情况
                        viIdxRange.set(1, i);
                    } else {
                        maxArea = Math.max(maxArea, vi * (viIdxRange.get(1) - viIdxRange.get(0) + 1));
                        viIdxRange.set(0, i);
                        viIdxRange.set(1, i);
                    }
                } else {
                    if (idxRange.get(0) - viIdxRange.get(1) == 1) {
                        idxRange.set(0, viIdxRange.get(0));
                    }
                }
            }
            // 最后添加自己
            viewedSet.add(heights[i]);
        }
        // 计算面积
        for (Map.Entry<Integer, List<Integer>> entry : continuesIdxMap.entrySet()) {
            maxArea = Math.max(maxArea, entry.getKey() * (entry.getValue().get(1) - entry.getValue().get(0) + 1));
        }
        return maxArea;
    }

    /**
     * AC 😀
     */
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0) {
            return maxArea;
        }
        LinkedList<List<Integer>> stack = new LinkedList<>();
        stack.add(new ArrayList<>(Arrays.asList(0, heights[0])));
        for (int i = 1; i < heights.length; i++) {
            List<Integer> lastPair = stack.peekLast();
            if (lastPair.get(1) < heights[i]) {
                // 维护一个递增的stack
                stack.addLast(new ArrayList<>(Arrays.asList(i, heights[i])));
            } else {
                int fromIndex = i;
                // 如果不是递增的则逐个弹出，确保递增
                while (!stack.isEmpty()) {
                    List<Integer> curPair = stack.pollLast();
                    if (curPair.get(1) > heights[i]) {
                        maxArea = Math.max(maxArea, curPair.get(1) * (i - curPair.get(0)));
                        // 扩展当前元素
                        fromIndex = curPair.get(0);
                    } else {
                        if (curPair.get(1) == heights[i]) {
                            // 相等时也要扩展当前元素
                            fromIndex = curPair.get(0);
                        } else {
                            // 如果小于当前元素，则要加回去不然就丢了
                            stack.addLast(curPair);
                        }
                        break;
                    }
                }
                stack.addLast(new ArrayList<>(Arrays.asList(fromIndex, heights[i])));
            }
        }
        if (!stack.isEmpty()) {
            for (List<Integer> eachPair : stack) {
                maxArea = Math.max(maxArea, eachPair.get(1) * (heights.length - eachPair.get(0)));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,1,5,6,2,3] -> 10
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        // [2,1,5,2,6,2,3] -> 10
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 2, 6, 2, 3}));
        // [2,1,5,2,6,2,1,3] -> 8
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 2, 6, 2, 1, 3}));
        // [2,1,5,2,6,2,1,3,1] -> 9
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 2, 6, 2, 1, 3, 1}));
        // [2,1,5,0,6,2,1,3,1] -> 6
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 0, 6, 2, 1, 3, 1}));
    }
}