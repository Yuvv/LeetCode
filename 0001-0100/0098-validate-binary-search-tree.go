package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// return (isValid, treeMin, treeMax)
func isValidAndGetMinMax(root *TreeNode) (bool, int, int) {
	if root.Left == nil && root.Right == nil {
		return true, root.Val, root.Val
	}
	leftValid, leftMin, leftMax := true, root.Val-1, root.Val-1
	rightValid, rightMin, rightMax := true, root.Val+1, root.Val+1
	if root.Left != nil {
		leftValid, leftMin, leftMax = isValidAndGetMinMax(root.Left)
	}
	if root.Right != nil {
		rightValid, rightMin, rightMax = isValidAndGetMinMax(root.Right)
	}
	if !leftValid || !rightValid {
		// 有一个不合法就整体不合法，不用管最大值了
		return false, root.Val, root.Val
	}
	if leftMax >= root.Val || root.Val >= rightMin {
		// 有一个不合法就整体不合法，不用管最大值了
		return false, root.Val, root.Val
	}
	if root.Left == nil {
		// 重新设置真实最小值
		leftMin = root.Val
	}
	if root.Right == nil {
		// 重新设置真实最小值
		rightMax = root.Val
	}

	return true, leftMin, rightMax
}

func isValidBST(root *TreeNode) bool {
	valid, _, _ := isValidAndGetMinMax(root)

	return valid
}

func main() {
	// true
	fmt.Println(isValidBST(&TreeNode{1, nil, nil}))
	// false
	fmt.Println(isValidBST(&TreeNode{1, &TreeNode{3, nil, nil}, &TreeNode{2, nil, nil}}))
}
