import java.util.*;
import java.util.stream.Collectors;

/*
 * 0902-numbers-at-most-n-given-digit-set.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/18
 */
public class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        Set<Integer> digitSet = Arrays.stream(digits).map(Integer::parseInt).collect(Collectors.toSet());
        Map<Integer, Integer> lteValMap = new HashMap<>();
        Map<Integer, Integer> ltCountMap = new HashMap<>();
        int last = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < 10; i++) {
            lteValMap.put(i, last);
            ltCountMap.put(i, count);
            if (j < digits.length && Integer.parseInt(digits[j]) == i) {
                last = Integer.parseInt(digits[j]);
                lteValMap.put(i, last);
                count++;
                j++;
            }
        }

        String nStr = n + "";
        int total = 0;
        int pow = 1;
        Map<Integer, Integer> cacheMap = new HashMap<>();
        cacheMap.put(0, 1);
        for (int i = 1; i <= nStr.length() - 1; i++) {
            pow *= digits.length;
            cacheMap.put(i, pow);
            total += pow;
        }
        int i;
        for (i = 0; i < nStr.length(); i++) {
            int val = nStr.charAt(i) - '0';
            if (val == 0) {
                break;
            }
            int lteVal = lteValMap.get(val);
            int ltCount = ltCountMap.getOrDefault(val, 0);
            if (ltCount <= 0 && lteVal < val) {
                break;
            }
            total += ltCount * cacheMap.getOrDefault(nStr.length() - 1 - i, 1);
            if (!digitSet.contains(val)) {
                break;
            }
        }
        String lastCharStr = nStr.substring(nStr.length() - 1);
        if (i >= nStr.length() && Arrays.asList(digits).contains(lastCharStr)) {
            total++;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 605
        System.out.println(s.atMostNGivenDigitSet(new String[] {"2","3","5","7","9"}, 7689));
        // 3030
        System.out.println(s.atMostNGivenDigitSet(new String[] {"2","3","5","7","9"}, 76189));
        // 54690
        System.out.println(s.atMostNGivenDigitSet(new String[] {"2", "3", "5", "7", "8", "9"}, 990834));
        // 1554
        System.out.println(s.atMostNGivenDigitSet(new String[] {"2", "3", "5", "7", "8", "9"}, 12378));
        // 348
        System.out.println(s.atMostNGivenDigitSet(new String[] {"2", "3", "5", "7", "8", "9"}, 2560));
        // 20
        System.out.println(s.atMostNGivenDigitSet(new String[] {"1", "3", "5", "7"}, 100));
        // 1
        System.out.println(s.atMostNGivenDigitSet(new String[] {"7"}, 8));
        // 29523
        System.out.println(s.atMostNGivenDigitSet(new String[] {"1", "4", "9"}, 1000000000));
        // 2
        System.out.println(s.atMostNGivenDigitSet(new String[] {"3", "4", "8"}, 4));
        // 18
        System.out.println(s.atMostNGivenDigitSet(new String[] {"3", "4", "5", "6"}, 64));
    }
}