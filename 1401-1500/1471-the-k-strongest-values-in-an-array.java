import java.util.*;

/*
 * 1471-the-k-strongest-values-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/05
 */
public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int[] res = new int[k];
        int i = 0;

        int beg = 0, end = arr.length - 1;
        while (i < k && beg <= end) {
            int x = Math.abs(arr[beg] - median);
            int y = Math.abs(arr[end] - median);
            if (x > y) {
                res[i++] = arr[beg];
                beg++;
            } else {
                res[i++] = arr[end];
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,1]
        System.out.println(Arrays.toString(s.getStrongest(
            new int[] {1,2,3,4,5}, 2
        )));
        // [5,5]
        System.out.println(Arrays.toString(s.getStrongest(
            new int[] {1,1,2,5,5}, 2
        )));
    }
}