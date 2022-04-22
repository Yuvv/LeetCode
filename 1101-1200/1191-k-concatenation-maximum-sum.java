/*
 * 1191-k-concatenation-maximum-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/22
 */
public class Solution {
    static final int MOD = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        // k >= 1 -> Kadane's algorithm
        long max = 0L;
        long localMax = 0L;
        for (int i = 0; i < arr.length; i++) {
            localMax = Math.max(arr[i], arr[i] + localMax);
            max = Math.max(max, localMax);
        }

        if (k >= 2) {
            // sum won't larger than 10^9
            long maxSuffixSum = arr[arr.length - 1];
            int[] suffixSum = new int[arr.length];
            suffixSum[suffixSum.length - 1] = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                suffixSum[i] = arr[i] + suffixSum[i + 1];
                maxSuffixSum = Math.max(maxSuffixSum, suffixSum[i]);
            }
            long maxPrefixSum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i - 1];
                maxPrefixSum = Math.max(maxPrefixSum, arr[i]);
            }
            max = Math.max(max, maxSuffixSum + maxPrefixSum);

            if (k >= 3) {
                max = Math.max(max, maxSuffixSum + maxPrefixSum + (long) arr[arr.length - 1] * (k - 2));
            }
        }

        return (int) (max % MOD);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.kConcatenationMaxSum(new int[] {1, 2}, 3));
        // 6
        System.out.println(s.kConcatenationMaxSum(new int[] {1, 2}, 2));
        // 3
        System.out.println(s.kConcatenationMaxSum(new int[] {1, 2}, 1));
        // 2
        System.out.println(s.kConcatenationMaxSum(new int[] {1, -2, 1}, 5));
        // 0
        System.out.println(s.kConcatenationMaxSum(new int[] {-1, -2}, 7));
        // 999999937
        System.out.println(s.kConcatenationMaxSum(new int[] {10000,10000,10000,10000,10000,10000,10000,10000,10000,10000}, 100000));
    }
}