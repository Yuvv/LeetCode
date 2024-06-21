/**
 * 1052-grumpy-bookstore-owner.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/21
 */
public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int gc = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            } else if (i < minutes) {
                gc += customers[i];
            }
        }
        int maxgc = gc;
        for (int i = minutes; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                gc += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                gc -= customers[i - minutes];
            }
            maxgc = Math.max(maxgc, gc);
        }

        return maxgc + total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 16
        System.out.println(s.maxSatisfied(
            new int[] {1,0,1,2,1,1,7,5},
            new int[] {0,1,0,1,0,1,0,1},
            3
        ));
        // 1
        System.out.println(s.maxSatisfied(
            new int[] {1},
            new int[] {0},
            1
        ));
        // 3005
        System.out.println(s.maxSatisfied(
            new int[] {621, 297, 7, 123, 328, 238, 944, 124, 745, 323},
            new int[] {1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
            2
        ));
    }
}