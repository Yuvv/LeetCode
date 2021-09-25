import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/*
 * 1109-corporate-flight-bookings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/25
 */
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] book : bookings) {
            for (int i = book[0] - 1; i < book[1]; i++) {
                res[i] += book[2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [10,55,45,25,25]
        System.out.println(Arrays.toString(s.corpFlightBookings(
            new int[][] {{1,2,10}, {2,3,20}, {2,5,25}},
            5
            )));
        // [10,25]
        System.out.println(Arrays.toString(s.corpFlightBookings(
            new int[][] {{1,2,10}, {2,2,15}},
            2
            )));
    }
}