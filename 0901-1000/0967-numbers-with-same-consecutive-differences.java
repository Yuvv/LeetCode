import java.util.*;

/*
 * 0967-numbers-with-same-consecutive-differences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/03
 */
public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        char[] arr = new char[n];
        List<Integer> resList = new ArrayList<>();
        find(arr, 0, k, resList);
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void find(char[] arr, int i, int k, List<Integer> resList) {
        if (i >= arr.length) {
            resList.add(Integer.parseInt(new String(arr)));
            return;
        }
        //System.out.println(Arrays.toString(arr));
        if (i == 0) {
            for (char x = '1'; x <= '9'; x++) {
                arr[i] = x;
                find(arr, i + 1, k, resList);
            }
        } else {
            char x = (char) (arr[i-1] + k);
            if (x <= '9') {
                arr[i] = x;
                find(arr, i + 1, k, resList);
            }
            x = (char) (arr[i-1] - k);
            if (x >= '0') {
                arr[i] = x;
                find(arr, i + 1, k, resList);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [181,292,707,818,929]
        System.out.println(Arrays.toString(s.numsSameConsecDiff(3, 7)));
        // [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
        System.out.println(Arrays.toString(s.numsSameConsecDiff(2, 1)));
    }
}