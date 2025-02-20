import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/*
 * 1980-find-unique-binary-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/27
 */
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = Stream.of(nums)
                .map(s -> Integer.parseInt(s, 2))
                .sorted()
                .collect(Collectors.toSet());
        String res = null;
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res = Integer.toBinaryString(i);
                break;
            }
        }
        while (res.length() < nums[0].length()) {
            res = "0" + res;
        }
        return res;
    }
    
    // submit at 2021/08/27
    public String findDifferentBinaryString_old(String[] nums) {
        List<Integer> list = Stream.of(nums)
                .map(s -> Integer.parseInt(s, 2))
                .sorted()
                .collect(Collectors.toList());
        String res = null;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(i)) {
                res = Integer.toBinaryString(i);
                break;
            }
        }
        if (res == null) {
            res = Integer.toBinaryString(list.size());
        }
        while (res.length() < nums[0].length()) {
            res = "0" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 11
        System.out.println(s.findDifferentBinaryString(new String[] {"01", "10"}));
        // 11
        System.out.println(s.findDifferentBinaryString(new String[] {"00", "01"}));
        // 101
        System.out.println(s.findDifferentBinaryString(new String[] {"111", "011", "001"}));
    }
}