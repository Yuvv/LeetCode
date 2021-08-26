import java.util.*;

/*
 * 0331-verify-preorder-serialization-of-a-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/26
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Iterator<String> it = Arrays.asList(nodes).iterator();
        return consumerNode(it) && !it.hasNext();
    }

    public boolean consumerNode(Iterator<String> it) {
        if (!it.hasNext()) {
            return false;
        }
        String ch = it.next();
        if ("#".equals(ch)) {
            return true;
        }
        boolean leftOk = consumerNode(it);
        if (!leftOk) {
            return false;
        }
        boolean rightOk = consumerNode(it);
        if (!rightOk) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        // false
        System.out.println(s.isValidSerialization("1,#"));
        // false
        System.out.println(s.isValidSerialization("9,#,#,1"));
    }
}