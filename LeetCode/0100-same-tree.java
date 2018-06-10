/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    /** wrong answer
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> lp = new ArrayList<>();
        getValList(p, lp);
        ArrayList<Integer> lq = new ArrayList<>();
        getValList(q, lq);
        
        if (lp.size() != lq.size()) {
            return false;
        }
        for (int i=0; i<lp.size(); i++) {
            if (lp.get(i) != lq.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void getValList(TreeNode p, List<Integer> resultList) {
        if (p == null) {
            resultList.add(null);
        } else {
            resultList.add(p.val);
            getValList(p.left, resultList);
            getValList(p.right, resultList);
        }
    }
    */
}