import java.util.*;

/*
 * 2121-intervals-between-identical-elements.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/10
 */
public class Solution {
    public long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        Map<Integer, List<Integer>> valIdxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            valIdxMap.computeIfAbsent(a, k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> idxList : valIdxMap.values()) {
            long sum = idxList.stream().mapToLong(Integer::longValue).sum();
            long prefixSum = 0L;
            for (int i = 0; i < idxList.size(); i++) {
                int idx = idxList.get(i);
                res[idx] = sum + ((long) idx) * (i - (idxList.size() - i)) - 2 * prefixSum;
                prefixSum += idx;
            }
        }

        //for (List<Integer> idxList : valIdxMap.values()) {
        //    int[] prefixSum = new int[idxList.size()];
        //    prefixSum[0] = idxList.get(0);
        //    for (int i = 1; i < idxList.size(); i++) {
        //        prefixSum[i] = prefixSum[i - 1] + idxList.get(i);
        //    }
        //    int[] suffixSum = new int[idxList.size()];
        //    suffixSum[idxList.size() - 1] = idxList.get(idxList.size() - 1);
        //    for (int i = idxList.size() - 2; i >= 0; i--) {
        //        suffixSum[i] = suffixSum[i + 1] + idxList.get(i);
        //    }
        //    for (int i = 0; i < idxList.size(); i++) {
        //        int idx = idxList.get(i);
        //        if (i > 0) {
        //            res[idx] += idx * i - prefixSum[i - 1];
        //        }
        //        if (i < idxList.size() - 1) {
        //            res[idx] += suffixSum[i + 1] - idx * (idxList.size() - i - 1);
        //        }
        //    }
        //}

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,2,7,2,4,4,5]
        System.out.println(Arrays.toString(s.getDistances(new int[] {2,1,3,1,2,3,3})));
        // [5,0,3,4]
        System.out.println(Arrays.toString(s.getDistances(new int[] {10,5,10,10})));
    }
}