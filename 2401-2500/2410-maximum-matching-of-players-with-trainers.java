import java.util.Arrays;
/**
 * 2410-maximum-matching-of-players-with-trainers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/13
 */
public class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        while (i < players.length) {
            while (j < trainers.length && trainers[j] < players[i]) {
                j++;
            }
            if (j >= trainers.length) {
                break;
            }
            j++;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
        // 1
        System.out.println(s.matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10}));
    }
}