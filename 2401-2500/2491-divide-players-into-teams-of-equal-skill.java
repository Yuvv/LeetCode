import java.util.*;

/**
 * 2491-divide-players-into-teams-of-equal-skill.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/08
 */
public class Solution {
    public long dividePlayers(int[] skill) {
        Map<Integer, Integer> sMap = new HashMap<>(skill.length/2+1);
        int sum = 0;
        for (int s : skill) {
            sum += s;
            sMap.put(s, sMap.getOrDefault(s, 0) + 1);
        }
        if (sum % (skill.length/2) > 0) {
            return -1;
        }
        int div = sum / (skill.length/2);
        long res = 0L;
        for (int s : skill) {
            Integer xCount = sMap.get(s);
            if (xCount == null) {
                continue;
            }
            Integer yCount = sMap.get(div - s);
            if (yCount == null) {
                return -1;
            }
            res += s * (div - s);
            if (s == div-s) {
                if (xCount == 2) {
                    sMap.remove(s);
                } else {
                    sMap.put(s, xCount-2);
                }
            } else {
                if (xCount == 1) {
                    sMap.remove(s);
                } else {
                    sMap.put(s, xCount-1);
                }
                if (yCount == 1) {
                    sMap.remove(div - s);
                } else {
                    sMap.put(div - s, yCount-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 22
        System.out.println(s.dividePlayers(new int[] {3,2,5,1,3,4}));
        // 12
        System.out.println(s.dividePlayers(new int[] {3,4}));
        // -1
        System.out.println(s.dividePlayers(new int[] {1,1,2,3}));
    }
}
