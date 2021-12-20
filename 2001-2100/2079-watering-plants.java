/*
 * 2079-watering-plants.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/20
 */
public class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int sum = 0;
        int cap = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (cap >= plants[i]) {
                sum++;
                cap -= plants[i];
            } else {
                sum += 2 * i + 1;
                cap = capacity - plants[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 14
        System.out.println(s.wateringPlants(new int[] {2,2,3,3}, 5));
        // 30
        System.out.println(s.wateringPlants(new int[] {1,1,1,4,2,3}, 4));
        // 49
        System.out.println(s.wateringPlants(new int[] {7,7,7,7,7,7,7}, 8));
    }
}