class Solution {
    /**
     * 递增递减字符串
     * https://leetcode.com/problems/di-string-match/
     */
    public int[] diStringMatch(String S) {
        int[] arr = new int[S.length() + 1];
        // 从大到小放数
        int max = S.length();
        // 在 D 的位置前面开始顺序放数
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                arr[i] = max;
                max--;
            }
        }
        // 在 I 的位置开始倒序放数
        for (int i = S.length() - 1; i >= 0 && max > 0; i--) {
            if (S.charAt(i) == 'I' && arr[i + 1] == 0) {
                arr[i + 1] = max;
                max--;
            }
        }
        // 顺序填补其它数
        for (int i = 0; i < arr.length && max > 0; i++) {
            if (arr[i] == 0) {
                arr[i] = max;
                max--;
            }
        }

        return arr;
    }
}