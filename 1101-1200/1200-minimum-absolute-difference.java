import java.util.*;

/*
 * 1200-minimum-absolute-difference.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/20
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> resList = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                resList.clear();
                minDiff = diff;
            }
            if (diff == minDiff) {
                resList.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2],[2,3],[3,4]]
        System.out.println(s.minimumAbsDifference(new int[] {4,2,1,3}));
        // [[1,3]]
        System.out.println(s.minimumAbsDifference(new int[] {1,3,6,10,15}));
        // [[-14,-10],[19,23],[23,27]]
        System.out.println(s.minimumAbsDifference(new int[] {3,8,-10,23,19,-4,-14,27}));
    }
}