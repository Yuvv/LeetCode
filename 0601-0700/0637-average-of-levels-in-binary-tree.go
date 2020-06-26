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

func averageOfLevels(root *TreeNode) []float64 {
	var resArr []float64
	var nodes []TreeNode
	var sum float64
	var count float64
	be, ed := 0, 1
	nodes = append(nodes, *root)
	for be < ed {
		sum = 0.0
		count = 0.0
		ned := ed
		for be < ned {
			sum += float64(nodes[be].Val)
			count++
			if nodes[be].Left != nil {
				nodes = append(nodes, *nodes[be].Left)
				ed++
			}
			if nodes[be].Right != nil {
				nodes = append(nodes, *nodes[be].Right)
				ed++
			}
			be++
		}
		resArr = append(resArr, sum/count)
	}
	return resArr
}

func main() {
	// [3, 14.5, 11]
	fmt.Println(averageOfLevels(&TreeNode{
		3,
		&TreeNode{9, nil, nil},
		&TreeNode{
			20,
			&TreeNode{15, nil, nil},
			&TreeNode{7, nil, nil},
		},
	}))
}
