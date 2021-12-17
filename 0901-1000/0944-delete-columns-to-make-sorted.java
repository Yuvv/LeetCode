/*
 * 0944-delete-columns-to-make-sorted.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/17
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int nCols = strs[0].length();
        for (int i = 0; i < nCols; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < ch) {
                    res++;
                    break;
                }
                ch = strs[j].charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minDeletionSize(new String[] {"cba","daf","ghi"}));
        // 3
        System.out.println(s.minDeletionSize(new String[] {"zyx","wvu","tsr"}));
    }
}