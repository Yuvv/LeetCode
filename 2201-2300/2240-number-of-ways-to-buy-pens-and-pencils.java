/**
 * 2240-number-of-ways-to-buy-pens-and-pencils
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/01
 */
public class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0L;
        int i = 0;
        while (i * cost1 <= total) {
            res += (total - i * cost1) / cost2 + 1;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.waysToBuyPensPencils(20, 10, 5));
        // 1
        System.out.println(s.waysToBuyPensPencils(5, 10, 10));
        // 500001500001
        System.out.println(s.waysToBuyPensPencils(1000000, 1, 1));
    }
}
