import java.util.*;
/**
 * 1415-the-k-th-lexicographical-string-of-all-happy-strings-of-length-n.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/20
 */
public class Solution {
    public String getHappyString(int n, int k) {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        for (int i = 1; i < n; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String s = list.pollFirst();
                char lastChar = s.charAt(s.length() - 1);
                if (lastChar == 'a') {
                    list.addLast(s + 'b');
                    list.addLast(s + 'c');
                } else if (lastChar == 'b') {
                    list.addLast(s + 'a');
                    list.addLast(s + 'c');
                } else {
                    list.addLast(s + 'a');
                    list.addLast(s + 'b');
                }
            }
        }
        for (int i = 0; i < k; i++) {
            if (list.isEmpty()) {
                return "";
            }
            if (i == k - 1) {
                return list.pollFirst();
            }
            list.pollFirst();
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "c"
        System.out.println(s.getHappyString(1, 3));
        // ""
        System.out.println(s.getHappyString(1, 4));
        // "cab"
        System.out.println(s.getHappyString(3, 9));
    }
}
