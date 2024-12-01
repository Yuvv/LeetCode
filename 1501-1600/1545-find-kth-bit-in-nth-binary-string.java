import java.util.*;

/**
 * 1545-find-kth-bit-in-nth-binary-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/12/15
 */
public class Solution {
    static Map<Integer, String> cacheMap = new HashMap<>();
    static {
        cacheMap.put(1, "0");
        cacheMap.put(2, "011");
        cacheMap.put(3, "0111001");
    }

    private String getNString(int n) {
        String s = cacheMap.get(n);
        if (s != null) {
            return s;
        }
        String prev = getNString(n-1);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        sb.append('1');
        for (int i = prev.length()-1; i >= 0; i--) {
            if (prev.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        s = sb.toString();
        cacheMap.put(n, s);
        return s;
    }

    public char findKthBit(int n, int k) {
        String s = getNString(n);
        return s.charAt(k-1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "0"
        System.out.println(s.findKthBit(3, 1));
        // "1"
        System.out.println(s.findKthBit(4, 11));
    }
}

