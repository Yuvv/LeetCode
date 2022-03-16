import java.util.*;

/*
 * 0957-prison-cells-after-n-days.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/16
 */
public class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int x = 0;
        int b = 1;
        int[] bitArr = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            x <<= 1;
            x |= cells[i];
            bitArr[cells.length - 1 - i] = b;
            b <<= 1;
        }
        Map<Integer, Integer> idxValMap = new HashMap<>();
        Map<Integer, Integer> valIdxMap = new HashMap<>();
        //idxValMap.put(0, x);
        //valIdxMap.put(x, 0);
        int idx = 0;
        while (n > 0) {
            int ox = x;
            for (int i = 0; i < bitArr.length; i++) {
                int bitPow = bitArr[i];
                if (i == 0 || i == bitArr.length - 1) {
                    // has only one neighbor, bit becomes 0
                    x &= (~bitPow);
                } else {
                    boolean bitXNext = (ox & bitArr[i + 1]) > 0;
                    boolean bitXPrev = (ox & bitArr[i - 1]) > 0;
                    if (bitXNext ^ bitXPrev) {
                        // not same -> vacant
                        x &= (~bitPow);
                    } else {
                        // same -> occupied
                        x |= bitPow;
                    }
                }
            }
            if (valIdxMap.containsKey(x)) {
                // duplicated
                break;
            }
            idxValMap.put(idx, x);
            valIdxMap.put(x, idx);
            idx++;
            n--;
        }

        if (n > 0) {
            // need do `n - 1`
            x = idxValMap.get((n - 1) % idxValMap.size());
        }
        for (int i = 0; i < cells.length; i++) {
            cells[i] = (x & bitArr[i]) > 0 ? 1 : 0;
        }
        return cells;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,0,0,0,1,1,0,0]
        System.out.println(Arrays.toString(s.prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 70)));
        // [0,0,1,1,0,0,0,0]
        System.out.println(Arrays.toString(s.prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7)));
        // [0,0,1,1,1,1,1,0]
        System.out.println(Arrays.toString(s.prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 1000000000)));
    }
}

