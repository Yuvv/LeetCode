import java.util.LinkedList;

/*
 * 0880-decoded-string-at-index.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/27
 */
public class Solution {
    public String decodeAtIndex_mem_limit(String s, int k) {
        StringBuilder sb = new StringBuilder();
        long times = 0L;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (times > 0) {
                    times *= ch - '0';
                } else {
                    times = ch - '0';
                }
                if (times * sb.length() > k) {
                    return sb.charAt((k-1) % sb.length()) + "";
                }
            } else {
                if (times > 0) {
                    String tmps = sb.toString();
                    times--;
                    while (times > 0) {
                        sb.append(tmps);
                        times--;
                    }
                }
                sb.append(ch);
            }
        }
        if (times > 0) {
            String tmps = sb.toString();
            times--;
            while (times > 0) {
                sb.append(tmps);
                times--;
            }
        }
        return sb.charAt(k-1) + "";
    }

    // stack
    public String decodeAtIndex(String s, int k) {
        LinkedList<Item> stack = new LinkedList<>();
        int beg = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                String str = s.substring(beg, i);
                long count = 1L;
                while (i < s.length() && ch >= '0' && ch <= '9') {
                    count *= (long) (ch - '0');
                    i++;
                    if (i < s.length()) {
                        ch = s.charAt(i);
                    }
                }
                Item item = new Item(str, count);
                if (stack.isEmpty()) {
                    item.totalLen = str.length() * count;
                } else {
                    item.totalLen = (stack.peek().totalLen + str.length()) * count;
                }
                stack.push(item);
                if (item.totalLen >= k) {
                    break;
                }
                beg = i;
                i--;
            }
        }

        while (!stack.isEmpty()) {
            Item item = stack.pop();
            long strLen = item.totalLen / item.count;
            k %= strLen;
            if (k == 0) {
                return "" + item.str.charAt(item.str.length() - 1);
            }
            if (k > strLen - item.str.length()) {
                return "" + item.str.charAt((int) (k + item.str.length() - strLen - 1));
            }
        }
        return "" + s.charAt(k - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "b"
        System.out.println(s.decodeAtIndex("a2b3c4d5e6f7g8h9", 3));
        // "h"
        System.out.println(s.decodeAtIndex("h5xk8ar9s222v93y22w2", 311373));
        // "o"
        System.out.println(s.decodeAtIndex("leet2code3", 10));
        // "h"
        System.out.println(s.decodeAtIndex("ha22", 5));
        // "a"
        System.out.println(s.decodeAtIndex("abc", 1));
        // "a"
        System.out.println(s.decodeAtIndex("a2345678999999999999999", 1));
        // "q"
        System.out.println(s.decodeAtIndex(
            "lqup4fznamvirw2pf9ant6sv9lj5rve6fdnvm4cbrmpu7pnqa6devbhuzdbqagp8itnsrylgxjkbhloe2gmdy2sc4xu7tljkzl9s",
            654582184
        ));
    }
}

class Item {
    String str;
    long count;
    long totalLen;

    public Item(String str, long count) {
        this.str = str;
        this.count = count;
        this.totalLen = 0;
    }

    @Override
    public String toString() {
        return "Item(str=" + str + ", count=" + count + ", totalLen=" + totalLen + ")";
    }
}