/**
 * 3442-maximum-difference-between-even-and-odd-frequency-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/04
 */
public class Solution {
    public int maxDifference(String s) {
        int[] cntarr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            cntarr[idx]++;
        }
        int maxOdd = 0, minEven = 0;
        for (int cnt : cntarr) {
            if (cnt > 0) {
                if (cnt % 2 == 1) {
                    if (maxOdd == 0 || maxOdd < cnt) {
                        maxOdd = cnt;
                    }
                } else {
                    if (minEven == 0 || minEven > cnt) {
                        minEven = cnt;
                    }
                }
            }
        }
        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxDifference("aaaaabbc"));
        // 3
        System.out.println(s.maxDifference("rrbqmhyummemjrkijidsxsnrcixntvrgvvezehnkbylafuuqkwbnvayxrxliylhfipsdaxfuhevzzdf"));
    }
}
