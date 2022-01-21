/*
 * 2138-divide-a-string-into-groups-of-size-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/21
 */
public class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length() / k + (s.length() % k == 0 ? 0 : 1);
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            res[i] = s.substring(i * k, Math.min(s.length(), (i + 1) * k));
            while (res[i].length() < k) {
                res[i] = res[i] + fill;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["abc", "def", "ghi"]
        System.out.println(s.divideString("abcdefghi", 3, 'x'));
        // ["abc","def","ghi","jxx"]
        System.out.println(s.divideString("abcdefghij", 3, 'x'));
    }
}