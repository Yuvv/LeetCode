/*
 * 0275-h-index-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/27
 */
public class Solution {
    public int hIndex(int[] citations) {
        int lo = 0, hi = citations.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int mih = citations.length - mi;
            if (citations[mi] >= mih) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        if (citations[lo] >= citations.length - lo) {
            return citations.length - lo;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.hIndex(new int[] {0,1,3,5,6}));
        // 2
        System.out.println(s.hIndex(new int[] {1,2,100}));
        // 3
        System.out.println(s.hIndex(new int[] {0,1,1,1,1,2,3,5,6}));
        // 0
        System.out.println(s.hIndex(new int[] {0}));
        // 1
        System.out.println(s.hIndex(new int[] {1}));
    }
}