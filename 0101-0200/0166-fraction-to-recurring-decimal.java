import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * 0166-fraction-to-recurring-decimal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/04
 */
public class Solution {
    public String fractionToDecimal(long numerator, long denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator < 0) {
            if (denominator > 0) {
                sb.append('-');
            } else {
                denominator = -denominator;
            }
            numerator = -numerator;
        }
        if (denominator < 0) {
            if (numerator > 0) {
                sb.append('-');
            }
            denominator = -denominator;
        }
        long integerPart = numerator / denominator;
        numerator = numerator % denominator;
        sb.append(integerPart);
        if (numerator == 0) {
            return sb.toString();
        }

        sb.append('.');

        List<Character> fractionalPart = new ArrayList<>();
        Map<Long, Integer> seenMap = new HashMap<>();
        numerator *= 10;
        int index = 0;
        int repeatIndex = -1;
        while (numerator != 0) {
            if (seenMap.containsKey(numerator)) {
                repeatIndex = seenMap.get(numerator);
                break;
            }
            seenMap.put(numerator, index);
            if (numerator < denominator) {
                fractionalPart.add('0');
            } else {
                long quotient = numerator / denominator;
                numerator = numerator % denominator;
                fractionalPart.add((char) ('0' + quotient));
            }
            numerator *= 10;
            index += 1;
        }

        for (int i = 0; i < fractionalPart.size(); i++) {
            if (i == repeatIndex) {
                sb.append('(');
            }
            sb.append(fractionalPart.get(i));
        }
        if (repeatIndex >= 0) {
            sb.append(')');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0.5
        System.out.println(s.fractionToDecimal(1, 2));
        // 2
        System.out.println(s.fractionToDecimal(2, 1));
        // 0.(6)
        System.out.println(s.fractionToDecimal(2, 3));
        // 0.(012)
        System.out.println(s.fractionToDecimal(4, 333));
        // 0.2
        System.out.println(s.fractionToDecimal(1, 5));
        // 0.3(18)
        System.out.println(s.fractionToDecimal(7, 22));
        // 0.5(60)
        System.out.println(s.fractionToDecimal(37, 66));
        // -6.25
        System.out.println(s.fractionToDecimal(-50, 8));
        // -6.25
        System.out.println(s.fractionToDecimal(-1, -2147483648));
    }
}