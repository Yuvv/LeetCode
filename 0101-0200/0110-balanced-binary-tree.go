package main

import "fmt"

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func balancedAndDepth(root *TreeNode) (bool, int) {
	if root == nil {
		return true, 0
	}
	leftBalanced, leftDepth := balancedAndDepth(root.Left)
	rightBalanced, rightDepth := balancedAndDepth(root.Right)
	if !leftBalanced || !rightBalanced {
		// 只要有一个不是平衡的，那就直接返回，深度无所谓
		return false, leftDepth
	}
	var diffDepth, maxDepth int
	if leftDepth < rightDepth {
		maxDepth = rightDepth + 1
		diffDepth = rightDepth - leftDepth
	} else {
		maxDepth = leftDepth + 1
		diffDepth = leftDepth - rightDepth
	}
	if diffDepth > 1 {
		return false, maxDepth
	}
	fmt.Println(diffDepth)
	return true, maxDepth
}

func isBalanced(root *TreeNode) bool {
	balanced, _ := balancedAndDepth(root)
	return balanced
}

func main() {
	// true
	fmt.Println(isBalanced(&TreeNode{
		3,
		&TreeNode{9, nil, nil},
		&TreeNode{
			20,
			&TreeNode{15, nil, nil},
			&TreeNode{7, nil, nil},
		},
	}))
	// false
	fmt.Println(isBalanced(&TreeNode{
		1,
		&TreeNode{2, nil, nil},
		&TreeNode{
			3,
			&TreeNode{4, &TreeNode{5, nil, nil}, &TreeNode{6, nil, nil}},
			&TreeNode{7, nil, nil},
		},
	}))
}
