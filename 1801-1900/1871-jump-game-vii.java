import java.util.*;

/*
 * 1871-jump-game-vii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/09
 */
public class Solution {

    public boolean canReach_tle(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        TreeSet<Integer> candidates = new TreeSet<>();
        // init candidates
        int min = s.length() - 1 - maxJump;
        int max = s.length() - 1 - minJump;
        for (int i = max; i >= 0 && i >= min; i--) {
            if (s.charAt(i) == '0') {
                candidates.add(i);
            }
        }
        // ..
        while (!candidates.isEmpty() && !candidates.contains(0)) {
            int first = candidates.pollFirst();
            min = first - maxJump;
            max = first - minJump;
            for (int i = max; i >= 0 && i >= min; i--) {
                if (s.charAt(i) == '0') {
                    candidates.add(i);
                }
            }
        }
        return candidates.contains(0);
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        TreeSet<Integer> candidates = new TreeSet<>();
        candidates.add(0);
        // slide window
        for (int i = 0; !candidates.isEmpty() && i < s.length(); i++) {
            int first = candidates.first();
            if (i == first + maxJump) {
                candidates.pollFirst();
            }
            int min = first + minJump;
            int max = Math.min(first + maxJump, s.length() - 1);
            if (i >= min && i <= max && s.charAt(i) == '0') {
                candidates.add(i);
            }
        }
        return candidates.contains(s.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.canReach("00111010", 3, 5));
        // true
        System.out.println(s.canReach("011010", 2, 3));
        // false
        System.out.println(s.canReach("01101110", 2, 3));
    }
}