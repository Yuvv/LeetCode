import java.util.*;

/*
 * 1750-minimum-length-of-string-after-deleting-similar-ends.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/04/12
 */
public class Solution {
    public int minimumLength(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            char a = s.charAt(begin);
            char b = s.charAt(end);
            if (a != b) {
                break;
            } else {
                while (begin < end && s.charAt(begin) == a) {
                    begin++;
                }
                while (begin < end && s.charAt(end) == b) {
                    end--;
                }
                if (begin == end && s.charAt(begin) == a) {
                    end--;
                }
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minimumLength("ca"));
        // 0
        System.out.println(s.minimumLength("cabaabac"));
        // 3
        System.out.println(s.minimumLength("aabccabba"));
        // 1
        System.out.println(s.minimumLength("a"));
        // 0
        System.out.println(s.minimumLength("aaaaaa"));
        // 1
        System.out.println(s.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}