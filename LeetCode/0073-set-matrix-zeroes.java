/**
 * 注意需要先保存所有位置，然后将对应位置行列置为 0
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, Boolean> rowMap = new HashMap<>();
        HashMap<Integer, Boolean> colMap = new HashMap<>();
        HashMap<Integer, List<Integer>> posMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!posMap.containsKey(i)) {
                        posMap.put(i, new ArrayList<>());
                    }
                    posMap.get(i).add(j);
                }
            }
        }

        for (Integer row :posMap.keySet()) {
            if (!rowMap.containsKey(row)) {
                for (int j=0; j<matrix[row].length; j++) {
                    matrix[row][j] = 0;
                }
                rowMap.put(row, true);
            }
            for (Integer col: posMap.get(row)) {
                if (!colMap.containsKey(col)) {
                    for (int i=0; i<matrix.length; i++) {
                        matrix[i][col] = 0;
                    }
                    colMap.put(col, true);
                }
            }
        }
    }
}