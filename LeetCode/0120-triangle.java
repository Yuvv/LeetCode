class Solution {
    /**
     * 找出最小累加和
     *  https://leetcode.com/problems/triangle/description/
     *
     * 遍历一遍算出每一轮的最小数
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> curList;
        for (int i = 1; i < triangle.size(); i++) {
            curList = triangle.get(i);
            for (int j = 0; j < curList.size(); j++) {
                curList.set(j, getMinValue(triangle, i, j));
            }
        }
        curList = triangle.get(triangle.size() - 1);
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < curList.size(); i++) {
            if (curList.get(i) < minValue) {
                minValue = curList.get(i);
            }
        }
        return minValue;
    }

    int getMinValue(List<List<Integer>> triangle, int row, int col) {
        int value = triangle.get(row).get(col);
        if (col == 0) {
            return value + triangle.get(row - 1).get(col);
        } else if (col == triangle.get(row).size() - 1) {
            return value + triangle.get(row - 1).get(col - 1);
        } else {
            return value + Math.min(triangle.get(row - 1).get(col - 1), triangle.get(row - 1).get(col));
        }
    }
}