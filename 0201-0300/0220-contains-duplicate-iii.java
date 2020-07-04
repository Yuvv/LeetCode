import java.util.TreeSet;

/*
 * 0220-contains-duplicate-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/07/04
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> sortedWindow = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Integer numJ = sortedWindow.ceiling(nums[i]);
            if (numJ != null && Math.abs((long)nums[i] - (long)numJ) <= t) {
                return true;
            }

            numJ = sortedWindow.floor(nums[i]);
            if (numJ != null && Math.abs((long)nums[i] - (long)numJ) <= t) {
                return true;
            }

            sortedWindow.add(nums[i]);

            if (sortedWindow.size() > k) {
                sortedWindow.remove(nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
            // true
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        // true
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        // false
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5}, 2, 3));
        // true
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{2, 2}, 2, 0));
        // false
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 4, 5, 6}, 3, 0));
    }
}