/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString().trim();
    }
    
    void serialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null ");
        } else {
            sb.append(node.val + " ");
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        Queue<String> queue = new LinkedList<String>();
        for(String str: data.split(" ")) {
            queue.add(str);
        }
        return deserialize(queue);
    }
    
    TreeNode deserialize(Queue<String> data) {
        String str = data.poll();

        if(str.equals("null")) {
            return null;
        }
        
        TreeNode curNode = new TreeNode(Integer.parseInt(str));
        curNode.left = deserialize(data);
        curNode.right = deserialize(data);

        return curNode;
    }
}