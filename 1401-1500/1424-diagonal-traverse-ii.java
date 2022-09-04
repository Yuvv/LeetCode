import java.util.*;

/*
 * 1424-diagonal-traverse-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/03
 */
public class Solution {
    public int[] findDiagonalOrder_tle(List<List<Integer>> nums) {
        int total = 0;
        for (List<Integer> lst : nums) {
            total += lst.size();
        }
        int[] res = new int[total];
        int k = 0;
        int si = 0, sj = 0;
        int i = 0, j = 0;
        int m = nums.size();
        int n = nums.get(m - 1).size();
        while (k < total) {
            if (i < 0) {
                si++;
                if (si >= m) {
                    si = m - 1;
                    sj++;
                }
                i = si;
                j = sj;
                continue;
            } else  if (i < nums.size() && j < nums.get(i).size()) {
                res[k] = nums.get(i).get(j);
                k++;
            }
            i--;
            j++;
        }
        return res;
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> a[0] + a[1]).thenComparingInt(a -> a[1])
        );
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> lst = nums.get(i);
            total += lst.size();
            for (int j = 0; j < lst.size(); j++) {
                pq.add(new int[] {i, j});
            }
        }
        int[] res = new int[total];
        int k = 0;
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            res[k++] = nums.get(pos[0]).get(pos[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,4,2,7,5,3,8,6,9]
        System.out.println(Arrays.toString(s.findDiagonalOrder(
            Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
            )
        )));
    }
}