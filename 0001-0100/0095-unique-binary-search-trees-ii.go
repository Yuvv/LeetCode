package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func recurisiveGenerateTrees(mn, mx int) []*TreeNode {
	result := make([]*TreeNode, 0)
	if mn > mx {
		return append(result, nil)
	}
	if mn == mx {
		return append(result, &TreeNode{mx, nil, nil})
	}

	var leftNodes, rightNodes []*TreeNode
	for x := mn; x <= mx; x++ {
		leftNodes = recurisiveGenerateTrees(mn, x-1)
		rightNodes = recurisiveGenerateTrees(x+1, mx)
		for _, ln := range leftNodes {
			for _, rn := range rightNodes {
				curNode := TreeNode{x, ln, rn}
				result = append(result, &curNode)
			}
		}
	}

	return result
}

func generateTrees(n int) []*TreeNode {
	return recurisiveGenerateTrees(1, n)
}

func main() {
	//
	fmt.Println(generateTrees(3))
}
