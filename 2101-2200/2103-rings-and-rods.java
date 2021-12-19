import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
/*
 * 2103-rings-and-rods.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/19
 */
public class Solution {
    public int countPoints(String rings) {
        Map<Character, Set<Character>> countMap = new HashMap<>(10);
        for (int i = 0; i < rings.length(); i += 2) {
            char rgbChar = rings.charAt(i);
            char rodChar = rings.charAt(i + 1);
            countMap.computeIfAbsent(rodChar, k -> new HashSet<>()).add(rgbChar);
        }
        return (int) countMap.values().stream().filter(x -> x.size() == 3).count();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.countPoints("B0B6G0R6R0R6G9"));
        // 1
        System.out.println(s.countPoints("B0R0G0R9R0B0G0"));
        // 0
        System.out.println(s.countPoints("G4"));
    }
}