package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func midWalk(root *TreeNode, k int, curNoPtr *int, resultPtr *int) {
	if *curNoPtr > k {
		return
	}
	if root != nil {
		midWalk(root.Left, k, curNoPtr, resultPtr)
		(*curNoPtr)++
		if (*curNoPtr) == k {
			(*resultPtr) = root.Val
			return
		}
		midWalk(root.Right, k, curNoPtr, resultPtr)
	}

}

func kthSmallest(root *TreeNode, k int) int {
	curNo := 0
	result := root.Val
	// 中序遍历
	midWalk(root, k, &curNo, &result)
	return result
}

func main() {
	// 1 expected
	fmt.Println(kthSmallest(&TreeNode{
		3,
		&TreeNode{1, nil, &TreeNode{2, nil, nil}},
		&TreeNode{4, nil, nil},
	},
		1))
}
