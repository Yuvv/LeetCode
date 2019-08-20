import java.util.List;
import java.util.ArrayList;

/*
 * 0045-jump-game-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/08/20
 */
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int target = nums.length - 1;
        if (nums[0] >= target) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            int lastIndex = list.size() - 1;
            if (list.get(lastIndex) + nums[list.get(lastIndex)] < i + nums[i]) {
                // 当前值域最大值超过前一个值域最大值
                if (lastIndex <= 0) {
                    // 第二个数直接加进去
                    list.add(i);
                } else if (list.get(lastIndex - 1) + nums[list.get(lastIndex - 1)] >= i) {
                    // 当前值域能够覆盖前一个的值域时，替换前一个
                    list.remove(lastIndex);
                    list.add(i);
                } else {
                    // 当前值域无法从倒数第二个值域到达是，需要添加
                    list.add(i);
                }
            }
            if (i + nums[i] >= target) {
                break;
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2 expected
        System.out.println(s.jump(new int[] {2, 3, 1, 1, 4}));
        // 2 expected
        System.out.println(s.jump(new int[] {3, 0, 8, 2, 0, 0, 1}));
        // 1 expected
        System.out.println(s.jump(new int[] {2, 0, 0}));
        // 1 expected
        System.out.println(s.jump(new int[] {1, 2}));
    }
}