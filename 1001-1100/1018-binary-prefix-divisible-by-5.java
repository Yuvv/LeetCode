import java.util.List;

class Solution {
    /**
     * 二进制数前缀部分能够被5整除
     * https://leetcode.com/problems/binary-prefix-divisible-by-5/
     *
     * @param A 二进制数组
     * @return 是否能被5整除
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);

        int remainder = 0;
        for (int i = 0; i < A.length; i++) {
            remainder = (A[i] + (remainder << 1)) % 5;
            result.add(remainder == 0);
        }

        return result;
    }
}