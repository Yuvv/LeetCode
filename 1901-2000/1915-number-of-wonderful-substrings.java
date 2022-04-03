import java.util.*;

/*
 * 1915-number-of-wonderful-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/19
 */
public class Solution {
    public long wonderfulSubstrings_tle(String word) {
        short[] arr = new short[word.length()];
        short xor = 0;
        for (int i = 0; i < word.length(); i++) {
            int mask = 1 << (word.charAt(i) - 'a');
            xor ^= mask;
            arr[i] = xor;
        }
        // calculate
        long count = 0L;  // word.length() -> single character
        for (int i = 0; i < arr.length; i++) {
            // self
            short a = arr[i];
            if ((a & (a - 1)) == 0) {
                count++;
            }
            for (int j = i + 1; j < arr.length; j++) {
                short b = arr[j];
                short x = (short) (a ^ b);
                if ((x & (x - 1)) == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public long wonderfulSubstrings(String word) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        int xor = 0;
        for (int i = 0; i < word.length(); i++) {
            int mask = 1 << (word.charAt(i) - 'a');
            xor ^= mask;
            map.put(xor, map.getOrDefault(xor, 0L) + 1L);
        }
        // calculate
        long count = 0L;  // word.length() -> single character
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if ((entry.getKey() & (entry.getKey() - 1)) == 0) {
                count += entry.getValue();
            }
            count += (entry.getValue() * (entry.getValue() - 1)) / 2;
            for (Map.Entry<Integer, Long> innerEntry : map.tailMap(entry.getKey(), false).entrySet()) {
                xor = entry.getKey() ^ innerEntry.getKey();
                if ((xor & (xor - 1)) == 0) {
                    count += entry.getValue() * innerEntry.getValue();
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.wonderfulSubstrings("aba"));
        // 9
        System.out.println(s.wonderfulSubstrings("aabb"));
        // 2
        System.out.println(s.wonderfulSubstrings("he"));
        // 226
        System.out.println(s.wonderfulSubstrings("eebjdgihigeehheeagcbedcgchjbcefidiiehjgafaejfecicjeeijafifdeajdiiccdhjbchcdiabgcdbhegbaffcbhjiejjchb"));
    }
}