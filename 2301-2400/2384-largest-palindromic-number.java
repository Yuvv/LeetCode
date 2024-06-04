/**
 * 2384-largest-palindromic-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/04
 */
public class Solution {
    public String largestPalindromic(String num) {
        int[] cntarr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            cntarr[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        // 1. find all multiple-nums
        for (int i = 9; i >= 0; i--) {
            if (cntarr[i] < 2) {
                continue;
            }
            if (i == 0 && sb.isEmpty()) {
                continue;
            }
            int cnt = cntarr[i];
            if (cntarr[i] % 2 == 1) {
                cnt--;
            }
            cntarr[i] -= cnt;
            cnt /= 2;
            while (cnt > 0) {
                sb.append((char)('0' + i));
                cnt--;
            }
        }
        int size = sb.length() - 1;
        // 2. find a maxium-num
        for (int i = 9; i >= 0; i--) {
            if (cntarr[i] == 0) {
                continue;
            }
            sb.append((char)('0' + i));
            break;
        }
        while (size >= 0) {
            sb.append(sb.charAt(size));
            size--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "7449447"
        System.out.println(s.largestPalindromic("444947137"));
        // "9"
        System.out.println(s.largestPalindromic("00009"));
    }
}