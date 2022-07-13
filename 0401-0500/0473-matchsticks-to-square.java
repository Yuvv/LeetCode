/*
 * 0473-matchsticks-to-square.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/12
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        java.util.Arrays.sort(matchsticks);
        int sum = 0;
        for (int mat : matchsticks) {
            sum += mat;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        boolean[] used = new boolean[matchsticks.length];
        return buildTarget(matchsticks, used, target, matchsticks.length - 1, target, 4);
    }

    private boolean buildTarget(int[] matchsticks, boolean[] used, int target,
                                int fromIdx, int len, int times) {
        if (times == 0) {
            for (boolean e : used) {
                if (!e) {
                    return false;
                }
            }
            return true;
        }
        for (int i = fromIdx; i >= 0; i--) {
            if (used[i] || matchsticks[i] > len) {
                continue;
            }

            len -= matchsticks[i];
            used[i] = true;

            int nextIdx = len == 0 ? matchsticks.length - 1 : i - 1;
            int nextLen = len == 0 ? target : len;
            int nextTimes = len == 0 ? times - 1 : times;
            boolean nextVal = buildTarget(matchsticks, used, target, nextIdx, nextLen, nextTimes);
            if (nextVal) {
                return nextVal;
            } else {
                len += matchsticks[i];
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.makesquare(new int[] {
            1,1,2,2,2
        }));
        // false
        System.out.println(s.makesquare(new int[] {
            3,3,3,3,4
        }));
    }
}