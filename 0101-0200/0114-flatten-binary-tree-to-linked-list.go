package main

import "fmt"


type TreeNode struct {
      Val int
      Left *TreeNode
      Right *TreeNode
 }

func flatten(root *TreeNode)  {
    if root == nil {
		return
	}
	if root.Right != nil {
		flatten(root.Right)
	}
	if root.Left != nil {
		flatten(root.Left)

		originRootRight := root.Right
		root.Right = root.Left
		root.Left = nil

		node := root
		for node.Right != nil {
			node = node.Right
		}
		node.Right = originRootRight
	}
}

func main() {
	root := &TreeNode{1, &TreeNode{2, &TreeNode{3, nil, nil}, &TreeNode{4, nil, nil}}, nil}
	flatten(root)

	// 1,2,3,4 expected
	for root != nil {
		fmt.Print(root.Val, "->")
		root = root.Right
	}
}