import java.util.Map;
import java.util.TreeMap;

/*
 * 0833-find-and-replace-in-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/20
 */
public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(s);
        TreeMap<Integer, String[]> map = new TreeMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], new String[]{sources[i], targets[i]});
        }
        int idxOffset = 0;
        for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
            int idx = entry.getKey();
            String source = entry.getValue()[0];
            String target = entry.getValue()[1];
            if (s.indexOf(source, idx) == idx) {
                sb.replace(idx + idxOffset, idx + idxOffset + source.length(), target);
                idxOffset += target.length() - source.length();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "eeecd"
        System.out.println(s.findReplaceString(
                "abcd",
                new int[]{0,2},
                new String[]{"ab", "ec"},
                new String[]{"eee", "fff"}
        ));
        // "eeebfffff"
        System.out.println(s.findReplaceString(
                "abcd",
                new int[]{0,2},
                new String[]{"a", "cd"},
                new String[]{"eee", "ffff"}
        ));
        // ""vbfrssozp"
        System.out.println(s.findReplaceString(
                "vmokgggqzp",
                new int[]{3, 5, 1},
                new String[]{"kg", "ggq", "mo"},
                new String[]{"s", "so", "bfr"}

        ));
    }
}