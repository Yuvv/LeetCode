import java.util.*;

/*
 * 1291-sequential-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/23
 */
public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int hiCnt = 0, hiVal = high;
        int loCnt = 0, loVal = low;
        while (loVal > 0) {
            loCnt++;
            loVal /= 10;
        }
        while (hiVal > 0)  {
            hiCnt++;
            hiVal /= 10;
        }

        List<Integer> res = new ArrayList<>();
        for (int cnt = loCnt; cnt <= hiCnt; cnt++) {
            LinkedList<Character> list = new LinkedList<>();
            // init
            char c;
            for (c = '1'; c <= ('0' + cnt); c++) {
                list.add(c);
            }
            c--;
            // enumrate
            while (c <= '9') {
                int val = 0;
                for (Character ch : list) {
                    val = val * 10 + (ch - '0');
                }
                if (val >= low && val <= high) {
                    res.add(val);
                }
                list.poll();
                c++;
                list.add(c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [123,234]
        System.out.println(s.sequentialDigits(100 ,300));
        // [1234,2345,3456,4567,5678,6789,12345]
        System.out.println(s.sequentialDigits(1000, 13000));
    }
}