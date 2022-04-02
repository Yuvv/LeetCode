import java.util.*;
import java.util.stream.Collectors;

/*
 * 0273-integer-to-english-words.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/02
 */
public class Solution {
    static final int BILLION = 1_000_000_000;
    static final int MILLION = 1_000_000;
    static final int THOUSAND = 1_000;
    static final int HUNDRED = 100;
    static final Map<Integer, String> NUMBER_MAP;
    static {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(HUNDRED, "Hundred");
        map.put(THOUSAND, "Thousand");
        map.put(MILLION, "Million");
        map.put(BILLION, "Billion");
        NUMBER_MAP = Collections.unmodifiableMap(map);
    }

    public String numberToWords(int num) {
        if (num <= 20) {
            return NUMBER_MAP.get(num);
        } else if (num < 100) {
            int remainder = num % 10;
            if (remainder == 0) {
                return NUMBER_MAP.get(num);
            }
            return NUMBER_MAP.get(num - remainder) + " " + NUMBER_MAP.get(remainder);
        } else {
            List<String> strs = new ArrayList<>();
            if (num >= BILLION) {
                strs.add(numberToWords(num / BILLION));
                strs.add(NUMBER_MAP.get(BILLION));
                num %= BILLION;
            }
            if (num >= MILLION) {
                strs.add(numberToWords(num / MILLION));
                strs.add(NUMBER_MAP.get(MILLION));
                num %= MILLION;
            }
            if (num >= THOUSAND) {
                strs.add(numberToWords(num / THOUSAND));
                strs.add(NUMBER_MAP.get(THOUSAND));
                num %= THOUSAND;
            }
            if (num >= 100) {
                strs.add(numberToWords(num / HUNDRED));
                strs.add(NUMBER_MAP.get(HUNDRED));
                num %= HUNDRED;
            }
            if (num > 0) {
                strs.add(numberToWords(num));
            }
            return strs.stream().collect(Collectors.joining(" "));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "One Hundred Twenty Three"
        System.out.println(s.numberToWords(123));
        // "Twelve Thousand Three Hundred Forty Five"
        System.out.println(s.numberToWords(12345));
        // "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        System.out.println(s.numberToWords(1234567));
    }
}