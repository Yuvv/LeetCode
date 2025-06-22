/**
 * 3443-maximum-manhattan-distance-after-k-changes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/22
 */
public class Solution {
    private int maxDistance(String s, int k, int dir) {
        int max = 0;
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'N':
                    if ((dir == 3 || dir == 4) && k > 0) { // move S
                        k--;
                        y--;
                    } else {
                        y++;
                    }
                    break;
                case 'S':
                    if ((dir == 1 || dir == 2) && k > 0) { // move N
                        k--;
                        y++;
                    } else {
                        y--;
                    }
                    break;
                case 'E':
                    if ((dir == 2 || dir == 4) && k > 0) {  // move W
                        k--;
                        x--;
                    } else {
                        x++;
                    }
                    break;
                case 'W':
                    if ((dir == 1 || dir == 3) && k > 0) { // move E
                        k--;
                        x++;
                    } else {
                        x--;
                    }
                    break;
                default:
                    break;
            }
            max = Math.max(max, Math.abs(x) + Math.abs(y));
        }
        return max;
    }

    public int maxDistance(String s, int k) {
        int max = 0;
        max = Math.max(max, maxDistance(s, k, 1)); // NE
        max = Math.max(max, maxDistance(s, k, 2)); // NW
        max = Math.max(max, maxDistance(s, k, 3)); // SE
        max = Math.max(max, maxDistance(s, k, 4)); // SW
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxDistance("NSEW", 1));
        // 6
        System.out.println(s.maxDistance("NSWWEW", 3));
    }
}