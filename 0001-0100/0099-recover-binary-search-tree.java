import java.util.*;


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

public class Solution {

	public List<Integer> dfsInOrder(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		if (root != null) {
			if (root.left != null) {
				resultList.addAll(dfsInOrder(root.left));
			}
			resultList.add(root.val);
			if (root.right != null) {
				resultList.addAll(dfsInOrder(root.right));
			}
		}
		return resultList;
	}

	public void travelAndSwap(TreeNode root, int var1, int var2) {
		LinkedList<TreeNode> nodeList = new LinkedList<>();
		nodeList.add(root);
		List<TreeNode> nodes = new ArrayList<>(2);
		while (!nodeList.isEmpty()) {
			TreeNode node = nodeList.poll();
			if (node.val == var1 || node.val == var2) {
				nodes.add(node);
			}
			if (node.left != null) {
				nodeList.push(node.left);
			}
			if (node.right != null) {
				nodeList.push(node.right);
			}
		}
		int tempVar = nodes.get(0).val;
		nodes.get(0).val = nodes.get(1).val;
		nodes.get(1).val = tempVar;
	}

    public void recoverTree(TreeNode root) {
        List<Integer> orderedNums = dfsInOrder(root);
		if (orderedNums.size() <= 1) {
			return;
		}
		// 两个数组中要么各有一个（相邻位置交换），要么各有两个
		List<Integer> notLtNum = new ArrayList<>(2);
		List<Integer> notGtNum = new ArrayList<>(2);
		for (int i = 0; i < orderedNums.size() - 1; i++) {
			Integer cur = orderedNums.get(i);
			Integer next = orderedNums.get(i + 1);
			if (cur > next) {
				notLtNum.add(cur);
				notGtNum.add(next);
			}
		}
		// 获取值
		Integer var1, var2;
		if (notLtNum.size() == 1) {
			var1 = notLtNum.get(0);
			var2 = notGtNum.get(0);
		} else {
			var1 = notLtNum.get(0);
			var2 = notGtNum.get(1);
		}
		// 尝试 swap
		travelAndSwap(root, var1, var2);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		// case 1
		s.recoverTree(new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null));
		// case 2
		s.recoverTree(new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null)));
		// case 3
		s.recoverTree(new TreeNode(3, new TreeNode(5), new TreeNode(4, null, new TreeNode(2))));
	}
}
