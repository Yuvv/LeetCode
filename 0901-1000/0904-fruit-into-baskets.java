import java.util.HashMap;
import java.util.Map;
/**
 * 0904-fruit-into-baskets.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/09
 */
public class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        while (j < fruits.length) {
            fruitCount.put(fruits[j], fruitCount.getOrDefault(fruits[j], 0) + 1);
            while (fruitCount.size() > 2) {
                Integer ic = fruitCount.get(fruits[i]);
                if (ic == 1) {
                    fruitCount.remove(fruits[i]);
                } else {
                    fruitCount.put(fruits[i], ic - 1);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.totalFruit(new int[]{1, 2, 1}));
        // 3
        System.out.println(s.totalFruit(new int[]{0, 1, 2, 2}));
        // 4
        System.out.println(s.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }
}