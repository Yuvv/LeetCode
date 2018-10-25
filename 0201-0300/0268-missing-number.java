class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, max = 0;
        boolean hasZero = false;
        for (int n: nums) {
            sum += n;
            if (n > max) {
                max = n;
            }
            if (n == 0) {
                hasZero = true;
            }
        }
        int result = max * (max + 1) / 2 - sum;
        if (hasZero && result == 0) {
            return max + 1;
        }
        return result;
    }
}