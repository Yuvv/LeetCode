/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 // 树的路径之和
 // https://leetcode.com/problems/path-sum/description/
func hasPathSum(root *TreeNode, sum int) bool {
    if root == nil {
        return false
    }
    if root.Val == sum && root.Left == nil && root.Right == nil {
        return true
    }
    return hasPathSum(root.Left, sum - root.Val) || hasPathSum(root.Right, sum - root.Val)
}