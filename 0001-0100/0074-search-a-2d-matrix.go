package main

import "fmt"

func searchMatrix(matrix [][]int, target int) bool {
	nRows := len(matrix)
	nCols := len(matrix[0])
	begin, end := 0, nRows*nCols-1
	var mid, sr, sc int
	for begin < end {
		mid = (begin + end) / 2
		sr = mid / nCols
		sc = mid % nCols
		if matrix[sr][sc] > target {
			end = mid - 1
		} else if matrix[sr][sc] < target {
			begin = mid + 1
		} else {
			return true
		}
	}
	sr = begin / nCols
	sc = begin % nCols
	if matrix[sr][sc] == target {
		return true
	}

	return false
}

func main() {
	// true
	fmt.Println(searchMatrix([][]int{{1, 3, 5, 7}, {10, 15, 17, 19}, {22, 25, 26, 28}}, 15))
	// false
	fmt.Println(searchMatrix([][]int{{1, 3, 5, 7}, {10, 15, 17, 19}, {22, 25, 26, 28}}, 13))
}
