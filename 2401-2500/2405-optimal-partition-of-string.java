import java.util.*;

/*
 * 2405-optimal-partition-of-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/12
 */
public class Solution {
    public int partitionString(String s) {
        int count = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count++;
                set.clear();
            }
            set.add(ch);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.partitionString("abacaba"));
        // 6
        System.out.println(s.partitionString("ssssss"));
    }
}