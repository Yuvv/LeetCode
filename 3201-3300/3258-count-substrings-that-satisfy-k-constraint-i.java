/**
 * 3258-count-substrings-that-satisfy-k-constraint-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/31
 */
public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int[] ones = new int[s.length()+1];
        int[] zeros = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeros[i+1] = zeros[i] + 1;
                ones[i+1] = ones[i];
            } else {
                ones[i+1] = ones[i] + 1;
                zeros[i+1] = zeros[i];
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (zeros[j+1]-zeros[i] <= k || ones[j+1]-ones[i] <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.countKConstraintSubstrings("10101", 1));
        // 25
        System.out.println(s.countKConstraintSubstrings("1010101", 2));
        // 15
        System.out.println(s.countKConstraintSubstrings("11111", 2));
    }
}
