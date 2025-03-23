import java.util.*;
/**
 * 1233-remove-sub-folders-from-the-filesystem.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/23
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> resList = new ArrayList<>();
        Trie root = new Trie("");
        for (String f : folder) {
            if (root.add(f)) {
                resList.add(f);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["/a","/c/d","/c/f"]
        System.out.println(s.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        // ["/a"]
        System.out.println(s.removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"}));
        // ["/a/b/c","/a/b/ca","/a/b/d"]
        System.out.println(s.removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
        // ["/ah/al/am","/ah/al"]
        System.out.println(s.removeSubfolders(new String[]{"/ah/al/am","/ah/al"}));
    }
}

class Trie {
    String val;
    boolean isEnd;
    Map<String, Trie> children;

    public Trie(String val) {
        this.val = val;
        this.children = new HashMap<>();
    }

    public boolean add(String path) {
        String[] parts = path.split("/");
        Trie cur = this;
        for (String part : parts) {
            if (path.isEmpty()) {
                continue;
            }
            if (cur.isEnd) {
                return false;
            }
            Trie next = cur.children.get(part);
            if (next == null) {
                next = new Trie(part);
                cur.children.put(part, next);
            }
            cur = next;
        }
        cur.isEnd = true;
        return true;
    }
}