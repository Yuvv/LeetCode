import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.right = right; this.left = left; }
    @Override
    public String toString() {
        return "TreeNode[val=" + val + ", left=" + left + ", right=" + right + "]";
    }
}

/*
 * 0449-serialize-and-deserialize-bst.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/14
 */
public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                sb.append(',');
                size--;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        TreeNode root;
        String nullStr = "null";
        if (nullStr.equals(arr[0])) {
            root = null;
        } else {
            root = new TreeNode(Integer.parseInt(arr[0]));
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while (i < arr.length && !queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    String left = arr[i++];
                    String right = arr[i++];
                    if (!nullStr.equals(left)) {
                        node.left = new TreeNode(Integer.parseInt(left));
                        queue.add(node.left);
                    }
                    if (!nullStr.equals(right)) {
                        node.right = new TreeNode(Integer.parseInt(right));
                        queue.add(node.right);
                    }
                    size--;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // --
        String data = s.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        System.out.println(data);
        TreeNode root = s.deserialize(data);
        System.out.println(root);
    }
}