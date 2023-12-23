import java.util.Set;
import java.util.HashSet;

/**
 * 1496-path-crossing
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/23
 */
public class Solution {
    public boolean isPathCrossing(String path) {
        int[] pt = new int[] { 0, 0 };
        Set<String> seen = new HashSet<>();
        seen.add("0,0");
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    pt[1]++;
                    break;
                case 'S':
                    pt[1]--;
                    break;
                case 'E':
                    pt[0]++;
                    break;
                case 'W':
                    pt[0]--;
                    break;
                default:
                    break;
            }
            String ptStr = pt[0] + "," + pt[1];
            if (seen.contains(ptStr)) {
                return true;
            }
            seen.add(ptStr);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.isPathCrossing("NES"));
        // true
        System.out.println(s.isPathCrossing("NESWW"));
    }
}
