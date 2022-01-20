/*
 * 1283-find-the-smallest-divisor-given-a-threshold.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/20
 */
public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }

        int lo = Math.max(1, sum / threshold);
        int hi = max;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(nums, threshold, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public boolean isPossible(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int n : nums) {
            int s = n / divisor + (n % divisor == 0 ? 0 : 1);
            sum += s;
            if (sum > threshold) {
                return false;
            }
        }
        return sum <= threshold;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.smallestDivisor(new int[] {1,2,5,9}, 6));
        // 44
        System.out.println(s.smallestDivisor(new int[] {44,22,33,11,1}, 5));
    }
}