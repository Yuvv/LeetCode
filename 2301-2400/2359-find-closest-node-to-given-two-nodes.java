import java.util.*;
/**
 * 2359-find-closest-node-to-given-two-nodes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/30
 */
public class Solution {
    private int[] getDis(int[] edges, int node) {
        int[] dis = new int[edges.length];
        Arrays.fill(dis, -1);
        int cnt = 0;
        while (node >= 0 && dis[node] < 0) {
            dis[node] = cnt++;
            node = edges[node];
        }
        return dis;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = getDis(edges, node1);
        int[] dis2 = getDis(edges, node2);
        int minDis = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (dis1[i] >= 0 && dis2[i] >= 0) {
                int maxDis = Math.max(dis1[i], dis2[i]);
                if (maxDis < minDis) {
                    minDis = maxDis;
                    ans = i;
                } else if (maxDis == minDis) {
                    ans = Math.min(ans, i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.closestMeetingNode(
                    new int[]{2,2,3,-1}, 0, 1));
        // 2
        System.out.println(s.closestMeetingNode(
                    new int[]{1,2,-1}, 0, 2));
    }
}
