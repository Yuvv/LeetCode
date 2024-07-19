/**
 * 2657-find-the-prefix-common-array-of-two-arrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/19
 */
public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            set.add(B[i]);
            res[i] = i*2 + 2 - set.size();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,2,3,4]
        System.out.println(s.findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4}));
        // [0,1,3]
        System.out.println(s.findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2}));
    }
}
