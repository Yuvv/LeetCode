/**
 * 交换二叉树左右子
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
		return nil
	}
	tmp := root.Left
	root.Left = root.Right
	root.Right = tmp

	invertTree(root.Left)
	invertTree(root.Right)

	return root
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */