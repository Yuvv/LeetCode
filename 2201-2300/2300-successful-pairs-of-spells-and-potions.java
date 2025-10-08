import java.util.Arrays;
/**
 * 2300-successful-pairs-of-spells-and-potions.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/10/08
 */
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int sp = spells[i];
            long target = success / sp;
            if (success % sp != 0) {
                target++;
            }
            // binary search target position
            int left = 0, right = potions.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < potions.length && potions[left] < target) {
                left++;
            }
            if (left < potions.length) {
                spells[i] = potions.length - left;
            } else {
                spells[i] = 0;
            }
        }

        return spells;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,0,3]
        System.out.println(Arrays.toString(
            s.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7)
        ));
        // [2,0,2]
        System.out.println(Arrays.toString(
            s.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)
        ));
    }
}