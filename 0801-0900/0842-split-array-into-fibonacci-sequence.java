import java.util.*;

/*
 * 0842-split-array-into-fibonacci-sequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/11
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        // MAX_INT = 2147483647
        for (int i = 1; i <= Math.min(num.length() / 2, 10); i++) {
            String as = num.substring(0, i);
            if (as.length() > 1 && as.charAt(0) == '0') {
                continue;
            }
            long a = Long.parseLong(as);
            if (a > Integer.MAX_VALUE) {
                continue;
            }
            for (int j = i + 1; j <= Math.min(i + 10, num.length() - i); j++) {
                String bs = num.substring(i, j);
                if (bs.length() > 1 && bs.charAt(0) == '0') {
                    continue;
                }
                long b = Long.parseLong(bs);
                if (b > Integer.MAX_VALUE) {
                    continue;
                }
                List<Integer> resList = new ArrayList<>();
                if (isOk(num, j, a, b, resList)) {
                    return resList;
                }
            }
        }
        return new ArrayList<>(0);
    }

    public boolean isOk(String num, int fromIdx, long a, long b, List<Integer> list) {
        if (fromIdx >= num.length()) {
            return false;
        }
        list.add((int) a);
        list.add((int) b);
        while (fromIdx < num.length()) {
            long c = a + b;
            if (c > Integer.MAX_VALUE) {
                return false;
            }
            list.add((int) c);
            String cs = "" + c;
            if (!num.startsWith(cs, fromIdx)) {
                return false;
            }
            a = b;
            b = c;
            fromIdx += cs.length();
        }
        return fromIdx == num.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [11,0,11,11]
        System.out.println(s.splitIntoFibonacci("1101111"));
        // []
        System.out.println(s.splitIntoFibonacci("112358130"));
        // []
        System.out.println(s.splitIntoFibonacci("0123"));
    }
}