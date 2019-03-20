import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 从数组中找出重复数字和缺失数字
     * https://leetcode.com/problems/set-mismatch/
     *
     * @param nums 数组
     * @return 结果
     */
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int[] result = new int[2];
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (map.containsKey(num)) {
                result[0] = num;
            } else {
                map.put(num, true);
            }
        }
        result[1] = nums.length * (nums.length + 1) / 2 - sum + result[0];
        return result;
    }
}