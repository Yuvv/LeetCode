import java.util.*;

/*
 * 0873-length-of-longest-fibonacci-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/06
 */
public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>(A.length);
        for (int e : A) {
            set.add(e);
        }
        int maxLen = 0;
        for (int i = 0; i < Math.min(A.length, A.length + 1 - maxLen); i++) {
            for (int j = i + 1; j < Math.min(A.length, A.length + 2 - maxLen); j++) {
                int a = A[i];
                int b = A[j];
                int c = a + b;
                int max = 0;
                while (set.contains(c)) {
                    max++;
                    a = b;
                    b = c;
                    c = a + b;
                }
                if (max > 0) {
                    maxLen = Math.max(maxLen, max + 2);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
        // 3
        System.out.println(s.lenLongestFibSubseq(new int[] {1,3,7,11,12,14,18}));
        // 7
        System.out.println(s.lenLongestFibSubseq(new int[] {1,2,3,5,8,13,21}));
        // 5
        System.out.println(s.lenLongestFibSubseq(new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
    }
}