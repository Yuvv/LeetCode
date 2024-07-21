/**
 * 2392-build-a-matrix-with-conditions.java
 * 
 * @date 2024/7/21
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Integer[] sortedRow = buildConditionMap(k, rowConditions);
        Integer[] sortedCol = buildConditionMap(k, colConditions);
        if (sortedRow == null || sortedCol == null) {
            return new int[][]{};
        }
        
        Map<Integer, Integer> colIdxMap = new HashMap<>();
        for (int i = 0; i < sortedCol.length; i++) {
            colIdxMap.put(sortedCol[i], i);
        }

        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            int val = sortedRow[i];
            matrix[i][colIdxMap.get(val)] = val;
        }

        return matrix;
    }

    private Integer[] buildConditionMap(int KK, int[][] conditions) {
        Map<Integer, Set<Integer>> condMap = new HashMap<>();
        for (int[] each : conditions) {
            condMap.computeIfAbsent(each[0], k -> new HashSet<>()).add(each[1]);
        }
        Set<Integer> alreadyTravel = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : condMap.entrySet()) {
            Set<Integer> alreadyChecked = new HashSet<>();
            alreadyChecked.add(entry.getKey());
            LinkedList<Integer> toCheck = new LinkedList<>(entry.getValue());
            while (!toCheck.isEmpty()) {
                Integer next = toCheck.pop();
                if (alreadyChecked.contains(next)) {
                    continue;
                }
                Set<Integer> nextSet = condMap.get(next);
                if (nextSet != null) {
                    entry.getValue().addAll(nextSet);
                    if (!alreadyTravel.contains(next)) {
                        for (Integer ns : nextSet) {
                            if (!alreadyChecked.contains(ns)) {
                                toCheck.push(ns);
                            }
                        }
                    }
                }
                alreadyChecked.add(next);
            }
            alreadyTravel.add(entry.getKey());
        }
        // check ring
        for (Map.Entry<Integer, Set<Integer>> entry : condMap.entrySet()) {
            if (entry.getValue().contains(entry.getKey())) {
                return null;
            }
        }

        Integer[] valArr = buildArray(KK, condMap);

        return valArr;
    }

    // buildArray - can't use Arrays.sort() or PriorityQueue
    private Integer[] buildArray(int KK, Map<Integer, Set<Integer>> condMap) {
        Integer[] arr = new Integer[KK];
        for (int i = 0; i< KK; i++) {
            arr[i] = i+1;
        }
        for (int i = 0; i<KK; i++) {
            for (int j = i+1; j<KK; j++) {
                if (condMap.containsKey(arr[i]) && condMap.get(arr[i]).contains(arr[j])) {
                    // i < j, do nothing
                } else if (condMap.containsKey(arr[j]) && condMap.get(arr[j]).contains(arr[i])) {
                    // j < i, swap
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                } else {
                    // unknown, do nothing
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
         // SpringApplication.run(MyappApplication.class, args);
        Solution s = new Solution();
        s.buildMatrix(
                8,
                new int[][]{
                        {1,2},{7,3},{4,3},{5,8},{7,8},{8,2},{5,8},{3,2},{1,3},{7,6},{4,3},{7,4},{4,8},{7,3},{7,5}
                },
                new int[][]{
                        {5,7},{2,7},{4,3},{6,7},{4,3},{2,3},{6,2}
                }
                );
    }
}