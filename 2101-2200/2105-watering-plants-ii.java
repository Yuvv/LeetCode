/*
 * 2105-watering-plants-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/03
 */
public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length - 1;
        int capA = capacityA, capB = capacityB;
        int sum = 0;
        while (i <= j) {
            if (i == j) {
                if (capA >= capB) {
                    if (capA < plants[i]) {
                        sum++;
                    }
                    i++;
                } else {
                    if (capB < plants[j]) {
                        sum++;
                    }
                    j--;
                }
            } else {
                if (capA < plants[i]) {
                    sum++;
                    capA = capacityA - plants[i];
                } else {
                    capA -= plants[i];
                }
                i++;
                if (capB < plants[j]) {
                    sum++;
                    capB = capacityB - plants[j];
                } else {
                    capB -= plants[j];
                }
                j--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minimumRefill(
            new int[] {2,2,3,3},
            5, 5
        ));
    }
}