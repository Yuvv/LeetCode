import java.util.*;

/**
 * 3218-minimum-cost-for-cutting-cake-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/03
 */
public class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int hWeight = 1;
        int vWeight = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return b[0]-a[0];});
        for (int h : horizontalCut) {
            pq.add(new int[] {h, h, hWeight, 0});
        }
        for (int v : verticalCut) {
            pq.add(new int[] {v, v, vWeight, 1});
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            if (item[3] == 0) {
                if (item[2] < hWeight) {
                    item[2] = hWeight;
                    item[0] = item[1] * item[2];
                    pq.add(item);
                } else {
                    res += item[0];
                    vWeight++;
                }
            } else {
                if (item[2] < vWeight) {
                    item[2] = vWeight;
                    item[0] = item[1] * item[2];
                    pq.add(item);
                } else {
                    res += item[0];
                    hWeight++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.minimumCost(3, 2, new int[]{1,3}, new int[]{5}));
        // 15
        System.out.println(s.minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }
}
