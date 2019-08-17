/*
 * 0046-permutations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/04/05
 */
class Solution {
    List<List<Integer>> lst = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);

        return lst;
    }

    public void permute(int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> arr = new ArrayList<>();
            for (int n: nums) {
                arr.add(n);
            }
            lst.add(arr);
        }

        for (int i = idx; i < nums.length; i++) {
            if (i == idx) {
                permute(nums, idx + 1);
            } else {
                swap(nums, i, idx);
                permute(nums, idx + 1);
                swap(nums, i, idx);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.permute(new int[]{1, 3, 5, 7});
        System.out.println(result);

        result = s.permute(new int[]{1, 3, 5, 1});
        System.out.println(result);
    }
}