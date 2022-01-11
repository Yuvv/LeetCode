/*
 * 1184-distance-between-bus-stops.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/11
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis1 = 0;
        int i = start;
        while (i != destination) {
            dis1 += distance[i];
            i++;
            i %= distance.length;
        }
        // reverse
        i = start;
        int dis2 = 0;
        while (i != destination && dis2 < dis1) {
            i = (i - 1 + distance.length) % distance.length;
            dis2 += distance[i];
        }
        return Math.min(dis1, dis2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.distanceBetweenBusStops(
            new int[] {1,2,3,4},
            0, 1
        ));
        // 3
        System.out.println(s.distanceBetweenBusStops(
            new int[] {1,2,3,4},
            0, 2
        ));
        // 4
        System.out.println(s.distanceBetweenBusStops(
            new int[] {1,2,3,4},
            0, 3
        ));
    }
}