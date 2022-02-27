/*
 * 0670-maximum-swap.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/27
 */
public class Solution {
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        char[] nscarr = ("" + num).toCharArray();
        int[] maxIdxArr = new int[nscarr.length];
        int maxIdx = nscarr.length - 1;
        maxIdxArr[maxIdx] = maxIdx;
        for (int i = nscarr.length - 2; i >= 0; i--) {
            if (nscarr[i] > nscarr[maxIdx]) {
                maxIdx = i;
            }
            maxIdxArr[i] = maxIdx;
        }

        int candidateIdx = 0;
        int toSwapIdx = -1;
        for (int i = 1; i < nscarr.length; i++) {
            maxIdx = maxIdxArr[i];
            if (nscarr[maxIdx] > nscarr[candidateIdx]) {
                toSwapIdx = maxIdx;
                break;
            } else {
                candidateIdx = i;
            }
        }
        if (toSwapIdx < 0) {
            return num;
        }
        char tmp = nscarr[candidateIdx];
        nscarr[candidateIdx] = nscarr[toSwapIdx];
        nscarr[toSwapIdx] = tmp;

        return Integer.parseInt(new String(nscarr));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7236
        System.out.println(s.maximumSwap(2736));
        // 9973
        System.out.println(s.maximumSwap(9973));
        // 9993824
        System.out.println(s.maximumSwap(9923894));
        // 80283835
        System.out.println(s.maximumSwap(50283838));
    }
}