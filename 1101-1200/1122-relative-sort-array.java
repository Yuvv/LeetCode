import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 1122-relative-sort-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/08
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        int i = 0;
        for (int j = 0; j < arr1.length; j++) {
            if (map.containsKey(arr1[j])) {
                swap(arr1, i, j);
                i++;
            }
        }
        Integer[] aaa = new Integer[i];
        for (int j = 0; j < i; j++) {
            aaa[j] = arr1[j];
        }
        Arrays.sort(aaa, 0, i, Comparator.comparingInt(map::get));
        Arrays.sort(arr1, i, arr1.length);
        for (int j = 0; j < i; j++) {
            arr1[j] = aaa[j].intValue();
        }
        return arr1;
    }

    public void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,2,2,1,4,3,3,9,6,7,19]
        System.out.println(Arrays.toString(s.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
        // [22,28,8,6,17,44]
        System.out.println(Arrays.toString(s.relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6})));
    }
}