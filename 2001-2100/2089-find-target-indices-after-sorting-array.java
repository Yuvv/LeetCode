import java.util.List;
import java.util.ArrayList;

/*
 * 2089-find-target-indices-after-sorting-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/01
 */
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 1 <= nums[i], target <= 100
        int[] cntArr = new int[nums.length + 1];
        for (int num : nums) {
            cntArr[num]++;
        }
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i < cntArr.length; i++) {
            if (i == target) {
                for (int j = idx; j < idx + cntArr[i]; j++) {
                    res.add(j);
                }
                break;
            }
            idx += cntArr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2]
        System.out.println(s.targetIndices(new int[] {1,2,5,2,3}, 2));
        // [3]
        System.out.println(s.targetIndices(new int[] {1,2,5,2,3}, 3));
        // [4]
        System.out.println(s.targetIndices(new int[] {1,2,5,2,3}, 5));
        // []
        System.out.println(s.targetIndices(new int[] {1,2,5,2,3}, 4));
    }
}