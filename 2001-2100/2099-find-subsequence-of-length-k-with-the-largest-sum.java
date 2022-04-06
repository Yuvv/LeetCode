import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * 2099-find-subsequence-of-length-k-with-the-largest-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/06
 */
public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // top-k, but can't lose the sequences
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> ((int[]) a)[0]));
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(new int[]{nums[i], i});
            while (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.stream()
                .sorted(Comparator.comparingInt(a -> a[1]))
                .mapToInt(a -> a[0])
                .toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,3]
        System.out.println(s.maxSubsequence(new int[] {2,1,3,3}, 2));
    }
}