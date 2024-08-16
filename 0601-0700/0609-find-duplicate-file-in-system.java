import java.util.*;
import java.util.stream.Collectors;

/**
 * 0609-find-duplicate-file-in-system.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/16
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] pieces = p.split(" ");
            for (int i = 1; i < pieces.length; i++) {
                int idx = pieces[i].indexOf("(");
                String fname = pieces[i].substring(0, idx);
                String content = pieces[i].substring(idx + 1, pieces[i].length() - 1);
                map.computeIfAbsent(content, k -> new ArrayList<>()).add(pieces[0] + "/" + fname);
            }
        }
        return map.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
        System.out.println(s.findDuplicate(new String[]{
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"
        }));
        // [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
        System.out.println(s.findDuplicate(new String[]{
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)"
        }));
    }
}

