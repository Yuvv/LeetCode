package main

import (
	"fmt"
)

func shiftGrid(grid [][]int, k int) [][]int {
	nRow := len(grid)
	nCol := len(grid[0])
	gridSize := nRow * nCol
	k %= gridSize
	if k == 0 {
		return grid
	}
	// 初始化一个暂存
	posFlag := make([]int, gridSize)
	curPos := 0
	for i := 0; i < nRow; i++ {
		for j := 0; j < nCol; j++ {
			posFlag[curPos] = grid[i][j]
			targetPos := (curPos - k + gridSize) % gridSize
			targetRow := targetPos / nCol
			targetCol := targetPos % nCol
			if targetPos < curPos {
				grid[i][j] = posFlag[targetPos]
			} else {
				grid[i][j] = grid[targetRow][targetCol]
			}
			curPos++
		}
	}
	return grid
}

func main() {
	// [[9,1,2],[3,4,5],[6,7,8]] expected
	fmt.Println(shiftGrid([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1))
	// [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]] expected
	fmt.Println(shiftGrid([][]int{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4))
}
