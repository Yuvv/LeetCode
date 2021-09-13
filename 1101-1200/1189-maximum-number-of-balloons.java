import java.util.Map;
import java.util.HashMap;

/*
 * 1189-maximum-number-of-balloons.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/13
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        int val = Math.min(map.getOrDefault('l', 0), map.getOrDefault('o', 0)) / 2;
        val = Math.min(val, map.getOrDefault('b', 0));
        val = Math.min(val, map.getOrDefault('a', 0));
        val = Math.min(val, map.getOrDefault('n', 0));
        return val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.maxNumberOfBalloons("nlaebolko"));
        // 2
        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));
        // 0
        System.out.println(s.maxNumberOfBalloons("leetcode"));
    }
}