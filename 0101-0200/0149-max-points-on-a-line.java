import java.util.Map;
import java.util.HashMap;

/*
 * 0149-max-points-on-a-line.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/15
 */
public class Solution {
    public int maxCommonDivisor(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        m = Math.abs(m);
        n = Math.abs(n);
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    public int maxPoints(int[][] points) {
        Map<String, Integer> pairCountMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int diffY = points[j][1] - points[i][1];
                int diffX = points[j][0] - points[i][0];
                String key;
                if (diffX == 0) {
                    key = "x=" + points[j][0];
                } else if (diffY == 0) {
                    key = "y=" + points[j][1];
                } else {
                    // y = kx + b
                    int gcd = maxCommonDivisor(diffY, diffX);
                    diffY /= gcd;
                    diffX /= gcd;
                    int bY = points[j][1] * diffX - points[j][0] * diffY;
                    int bX;
                    if (bY == 0) {
                        bX = 0;
                    } else {
                        int gcdB = maxCommonDivisor(bY, diffX);
                        bX = diffX / gcdB;
                        bY /= gcdB;
                    }
                    // make sign in static position
                    if (diffY < 0 && diffX < 0 || diffY > 0 && diffX < 0) {
                        diffX = -diffX;
                        diffY = -diffY;
                    }
                    if (bY < 0 && bX < 0 || bY > 0 && bX < 0) {
                        bX = -bX;
                        bY = -bY;
                    }
                    key = diffY + "," + diffX + "," + bY + "," + bX;
                }
                int val = pairCountMap.getOrDefault(key, 0) + 1;
                pairCountMap.put(key, val);
                max = Math.max(max, val);
            }
        }
        // max = n * (n - 1) / 2
        return (int) ((Math.sqrt(1.0 + 8 * max) + 1) / 2.0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxPoints(new int[][] {{1,1},{2,2},{3,3}}));
        // 4
        System.out.println(s.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
        // 4
        System.out.println(s.maxPoints(new int[][] {{1,1},{3,2},{5,3},{2,2},{4,1},{2,3},{1,4},{8,9},{4,3},{7,1},{8,2},{9,3}}));
    }
}