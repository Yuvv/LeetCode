import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;

/*
 * 1997-first-day-where-you-have-been-in-all-the-rooms.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/11
 */
public class Solution {
    private Map<Integer, Map<Integer, Integer>> cacheMap;
    public int firstDayBeenInAllRooms_tle(int[] nextVisit) {
        cacheMap = new HashMap<>();

        return getFirstDayInAll(nextVisit, 0, nextVisit.length - 1);
    }

    public int getFirstDayInAll(int[] nextVisit, int from, int to) {
        if (cacheMap.containsKey(from) && cacheMap.get(from).containsKey(to)) {
            return cacheMap.get(from).get(to);
        }
        int day;
        if (from == to - 1) {
            if (nextVisit[from] == from) {
                day = 2;
            } else {
                day = getFirstDayInAll(nextVisit, nextVisit[from], from);
            }
        } else {
            int x = getFirstDayInAll(nextVisit, from, to - 1);
            if (nextVisit[to - 1] == to - 1) {
                day = x + 2;
            } else {
                day = x + getFirstDayInAll(nextVisit, nextVisit[to - 1], to - 1) + 2;
            }
        }
        day %= 1000000007;
        cacheMap.computeIfAbsent(from, key -> new HashMap<>()).put(to, day);
        return day;
    }

     public int firstDayBeenInAllRooms(int[] nextVisit) {
         BigInteger[] dp = new BigInteger[nextVisit.length];
         dp[0] = new BigInteger("0");
         BigInteger one = new BigInteger("1");
         BigInteger mod = new BigInteger("1000000007");
         for (int i = 0; i < nextVisit.length - 1; i++) {
             dp[i + 1] = dp[i].subtract(dp[nextVisit[i]]).add(one).add(dp[i]).add(one).mod(mod);
         }
         return dp[nextVisit.length - 1].intValue();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.firstDayBeenInAllRooms(new int[] {0, 0}));
        // 6
        System.out.println(s.firstDayBeenInAllRooms(new int[] {0, 0, 2}));
        // 6
        System.out.println(s.firstDayBeenInAllRooms(new int[] {0, 1, 2, 0}));
        // 16
        System.out.println(s.firstDayBeenInAllRooms(new int[] {0, 0, 2, 1, 3}));
        // 2048
        System.out.println(s.firstDayBeenInAllRooms(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 8}));
    }
}