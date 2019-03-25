class Solution {
    /**
     * 将数组分为三个相等的部分
     * 1. 求和再分两边计算。
     * 2. 两个指针往中间靠（这种对负数难处理，测试没通过，日后再想想）
     *
     * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
     * @param A 数组
     * @return 是否可以分
     */
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int sum = 0;
        int left = 0, right = A.length - 1;
        for (int i = left; i <= right; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int sumLeft = 0, sumRight = 0;
        while (sumLeft != sum && left < right) {
            sumLeft += A[left];
            left++;
        }
        while (sumRight != sum && left < right) {
            sumRight += A[right];
            right--;
        }

        return left < right || sum == A[right];
    }
}