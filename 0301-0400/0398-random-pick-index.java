import java.util.*;

/*
 * 0398-random-pick-index.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/13
 */
class Solution {
    Map<Integer, List<Integer>> map;
    Random random;

    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random(System.currentTimeMillis());
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[] {1, 2, 3, 3, 3});
        // ->
        System.out.println(s.pick(3));
        System.out.println(s.pick(3));
        System.out.println(s.pick(1));
        System.out.println(s.pick(3));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */