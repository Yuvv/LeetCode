import java.util.*;

/*
 * 0018-4sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/11/16
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.computeIfAbsent(nums[i] + nums[j], k -> new ArrayList<>())
                    .add(new int[] {i, j});
            }
        }

        Set<NSum<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[i] - nums[j])) {
                    for (int[] pair : map.get(target - nums[i] - nums[j])) {
                        if (i != pair[0] && j != pair[0] &&
                                i != pair[1] && j != pair[1]) {
                            set.add(new NSum<>(nums[i], nums[j], nums[pair[0]], nums[pair[1]]));
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (NSum<Integer> each: set) {
            result.add(each.nums);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(s.fourSum(new int[] {1,0,-1,0,-2,2}, 0));
        // [[2,2,2,2]]
        System.out.println(s.fourSum(new int[] {2,2,2,2,2}, 8));
    }
}

class NSum<T> {
    List<T> nums;
    private String numStr;

    public NSum(T... nums) {
        this.nums = new ArrayList<>();
        Arrays.sort(nums);
        Collections.addAll(this.nums, nums);
        this.numStr = Arrays.toString(nums);
    }

    @Override
    public int hashCode() {
        return numStr.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NSum) {
            NSum other = (NSum) o;
            if (nums.size() != other.nums.size()) {
                return false;
            }
            for (int i = 0; i < other.nums.size(); i++) {
                if (!other.nums.get(i).equals(nums.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}