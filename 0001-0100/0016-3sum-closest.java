class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        int begin, end;
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            begin = i + 1;
            end = nums.length - 1;
            while (begin < end) {
                sum = nums[i] + nums[begin] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    begin++;
                }
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}