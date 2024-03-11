import java.util.Arrays;
/**
 * 3074-apple-redistribution-into-boxes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/11
 */
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }
        int i = capacity.length - 1;
        while (i >= 0 && sum > 0) {
            sum -= capacity[i];
            i--;
        }
        return capacity.length - i -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minimumBoxes(new int[]{1,3,2}, new int[]{4,3,1,5,2}));
        // 4
        System.out.println(s.minimumBoxes(new int[]{5,5,5}, new int[]{2,4,2,7}));
    }
}