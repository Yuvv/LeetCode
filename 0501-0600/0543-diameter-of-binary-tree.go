package main

import (
	"fmt"
)

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func max(nums... int) int {
	maxVal := nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] > maxVal {
			maxVal = nums[i]
		}
	}
	return maxVal
}

func longestPath(root *TreeNode) (int, int) {
	if root.Left == nil && root.Right == nil {
		return 0, 0
	}
	var leftDepth, leftLongestPath int
	var rightDepth, rightLongestPath int
	var leftToRightPath int
	if root.Left == nil {
		leftDepth, leftLongestPath = 0, 0
	} else {
		leftDepth, leftLongestPath = longestPath(root.Left)
	}
	if root.Right == nil {
		rightDepth, rightLongestPath = 0, 0
	} else {
		rightDepth, rightLongestPath = longestPath(root.Right)
	}
	if root.Left != nil && root.Right != nil {
		// 左右子树都有节点
		leftToRightPath = leftDepth + rightDepth + 2
	} else {
		// 左右子树中有一个没有节点
		leftToRightPath = leftDepth + rightDepth + 1
	}

	maxDepth := max(leftDepth, rightDepth) + 1
	longestPath := max(leftToRightPath, leftLongestPath, rightLongestPath)

	return maxDepth, longestPath
}

// PS: 没有人告诉我这是一棵平衡二叉树啊。。。。
func diameterOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}
	_, longestPath := longestPath(root)
	return longestPath
}

func main() {
	// 3 expected
	fmt.Println(diameterOfBinaryTree(&TreeNode{
		1,
		&TreeNode{2, &TreeNode{4, nil, nil}, &TreeNode{5, nil, nil}},
		&TreeNode{3, nil, nil},
	}))
	// 1 expected
	fmt.Println(diameterOfBinaryTree(&TreeNode{
		1,
		&TreeNode{2, nil, nil},
		nil,
	}))
	// 2 expected
	fmt.Println(diameterOfBinaryTree(&TreeNode{
		1,
		&TreeNode{2, nil, nil},
		&TreeNode{3, nil, nil},
	}))
	// 0 expected
	fmt.Println(diameterOfBinaryTree(nil))
}
