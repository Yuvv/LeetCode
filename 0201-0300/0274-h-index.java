import java.util.Arrays;

/*
 * 0274-h-index.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/27
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                // first one is best one
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.hIndex(new int[] {3,0,6,1,5}));
        // 1
        System.out.println(s.hIndex(new int[] {1,3,1}));
        // 3
        System.out.println(s.hIndex(new int[] {1,3,4,5,3,2,3,2,3,1}));
    }
}