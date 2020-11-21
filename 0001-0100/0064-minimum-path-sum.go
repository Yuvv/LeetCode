package main

import (
	"fmt"
)

// just dp
func minPathSum(grid [][]int) int {
	rows := len(grid)
	cols := len(grid[0])
	var ri, ci int
	// 初始化第一行第一列
	for ci = 1; ci < cols; ci++ {
		grid[ri][ci] += grid[ri][ci-1]
	}
	for ri = 1; ri < rows; ri++ {
		grid[ri][0] += grid[ri-1][0]
	}
	// 遍历中间的值
	for ri = 1; ri < rows; ri++ {
		for ci = 1; ci < cols; ci++ {
			if grid[ri-1][ci] > grid[ri][ci-1] {
				grid[ri][ci] += grid[ri][ci-1]
			} else {
				grid[ri][ci] += grid[ri-1][ci]
			}
		}
	}
	return grid[ri-1][ci-1]
}

func main() {
	// 7 expected
	fmt.Println(minPathSum([][]int{
		{1, 3, 1},
		{1, 5, 1},
		{4, 2, 1},
	}))
	// 12 expected
	fmt.Println(minPathSum([][]int{
		{1, 2, 3},
		{4, 5, 6},
	}))
}
