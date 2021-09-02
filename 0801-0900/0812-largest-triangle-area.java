/*
 * 0812-largest-triangle-area.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/02
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max =0;

        for (int i =0; i < n; i++) {
            for (int j =i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = 0;
                    int[] a = points[i];
                    int[] b = points[j];
                    int[] c = points[k];
                    area = Math.abs(area(a,b)+area(b,c)+area(c,a));
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    public double area(int[] a, int[] b) {
        int l = b[0] - a[0];
        double h = (a[1] + b[1] + 200) / 2.0;
        return l * h;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2.00000
        System.out.println(s.largestTriangleArea(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, 2},
                new int[]{2, 0}
        }));
        // 0.50000
        System.out.println(s.largestTriangleArea(new int[][]{
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{0, 1}
        }));
    }
}