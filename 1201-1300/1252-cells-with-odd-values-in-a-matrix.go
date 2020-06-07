package main

import (
	"fmt"
)

func oddCells(n int, m int, indices [][]int) int {
	rowMap := make(map[int]int)
	colMap := make(map[int]int)

	for i := 0; i < len(indices); i++ {
		rowVal, ok := rowMap[indices[i][0]]
		if !ok || rowVal <= 0 {
			rowMap[indices[i][0]] = m
		} else if rowVal > 0 {
			rowMap[indices[i][0]] = 0
		}
		colVal, ok := colMap[indices[i][1]]
		if !ok || colVal <= 0 {
			colMap[indices[i][1]] = n
		} else if colVal > 0 {
			colMap[indices[i][1]] = 0
		}
	}

	sum := 0
	for _, v := range rowMap {
		sum += v
	}
	for _, v := range colMap {
		sum += v
		if v > 0 {
			for _, rv := range rowMap {
				if rv > 0 {
					// 都变过奇数次，减去 row+col 的两个计数
					sum -= 2
				}
			}
		}
	}
	return sum
}

func main() {
	// 6 expected
	fmt.Println(oddCells(2, 3, [][]int{{0, 1}, {1, 1}}))
	// 0 expected
	fmt.Println(oddCells(2, 2, [][]int{{1, 1}, {0, 0}}))
}