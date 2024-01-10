import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 2385-amount-of-time-for-binary-tree-to-be-infected
 *
 * @date 2024/1/10
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int count = 0;
        Map<Integer, int[]> adjMap = new HashMap<>();
        LinkedList<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{-1, root});
        while (!queue.isEmpty()) {
            Object[] item = queue.pollFirst();
            int[] value = new int[3];
            value[0] = (int)item[0];
            TreeNode node = (TreeNode) item[1];
            if (node.left != null) {
                value[1] = node.left.val;
                queue.addLast(new Object[]{node.val, node.left});
            } else {
                value[1] = -1;
            }
            if (node.right != null) {
                value[2] = node.right.val;
                queue.addLast(new Object[]{node.val, node.right});
            } else {
                value[2] = -1;
            }
            adjMap.put(node.val, value);
        }
        //
        LinkedList<Integer> infected = new LinkedList<>();
        infected.add(start);
        while (!adjMap.isEmpty()) {
            int size = infected.size();
            while (size > 0) {
                Integer it = infected.pollFirst();
                int[] adj = adjMap.remove(it);
                if (adj != null) {
                    for (int i = 0; i < adj.length; i++) {
                        if (adj[i] >= 0 && adjMap.containsKey(adj[i])) {
                            infected.addLast(adj[i]);
                        }
                    }
                }
                size--;
            }
            if (!infected.isEmpty()) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int time = s.amountOfTime(
                new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))), new TreeNode(3, new TreeNode(10), new TreeNode(6))), 
                3);
        System.out.println("time=" + time); // 4
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
