import java.util.List;
import java.util.ArrayList;

/*
 * 0179-largest-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/06
 */
public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add("" + num);
        }

        // reverse sorted - note: 其实ab拼接比较更快，这里用了没拼接的方式
        list.sort(((Comparator<String>) (a, b) -> {
            int i = 0, j = 0;
            while (i < a.length() && i < b.length()) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return a.charAt(i) - b.charAt(i);
                }
            }
            String originA = a, originB = b;
            // let a longer than b
            if (j < b.length()) {
                String tmp = a;
                a = b;
                b = tmp;
            }
            // scan a from pos_j
            j = 0;
            while (i < a.length() && a.charAt(i) == a.charAt(j)) {
                i++;
                j++;
            }
            if (i < a.length()) {
                if (originA.length() >= originB.length()) {
                    return a.charAt(i) - a.charAt(j);
                } else {
                    return a.charAt(j) - a.charAt(i);
                }
            }
            // scan b from pos_i
            i = 0;
            while (i < b.length() && a.charAt(j) == b.charAt(i)) {
                i++;
                j++;
            }
            if (i < b.length()) {
                if (originA.length() >= originB.length()) {
                    return b.charAt(i) - a.charAt(j);
                } else {
                    return a.charAt(j) - b.charAt(i);
                }
            }
            return 0;
        }).reversed());

        String s = String.join("", list);
        if (s.charAt(0) == '0') {
            return "0";
        }
        return s;
    }

    public static void main(String[] args) throws Exception {

        Scratch s = new Scratch();

         // 1
        System.out.println(s.largestNumber(new int[]{1}));
        // 10
        System.out.println(s.largestNumber(new int[]{10}));
        // 210
        System.out.println(s.largestNumber(new int[]{10, 2}));
        // 9534330
        System.out.println(s.largestNumber(new int[]{3, 30, 34, 5, 9}));
        // 3323130230130
        System.out.println(s.largestNumber(new int[]{3, 30, 31, 32, 301, 302}));
        // 21111111111
        System.out.println(s.largestNumber(new int[]{1, 11, 111, 1111, 2}));
        // 343234323
        System.out.println(s.largestNumber(new int[]{34323, 3432}));
        // 0
        System.out.println(s.largestNumber(new int[]{0, 0}));
    }
}