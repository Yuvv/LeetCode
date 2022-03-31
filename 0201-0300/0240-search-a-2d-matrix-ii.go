package main

import (
	"fmt"
)

// search-a-2d-matrix-ii
func searchMatrix(matrix [][]int, target int) bool {
	w, h := len(matrix[0]), len(matrix)
	ri, rj := 0, h-1
	ci, cj := 0, w-1
	if matrix[ri][ci] > target {
		return false
	}
	if matrix[rj][cj] < target {
		return false
	}
	// find edge
	var m, i, j int
	for ri < rj || ci < cj {
		if ri == 0 && rj == 3 && ci == 0 && cj == 0 {
			break
		}
		// find bottom-edge
		i, j = ri, rj
		for i < j {
			m = (i + j) / 2
			if matrix[m][ci] > target {
				j = m - 1
			} else if matrix[m][ci] < target {
				i = m + 1
			} else {
				return true // fast return
			}
		}
		if matrix[i][ci] > target {
			rj = i - 1
		} else {
			rj = i
		}
		// find right-edge
		i, j = ci, cj
		for i < j {
			m = (i + j) / 2
			if matrix[ri][m] > target {
				j = m - 1
			} else if matrix[ri][m] < target {
				i = m + 1
			} else {
				return true // fast return
			}
		}
		if matrix[ri][i] > target {
			cj = i - 1
		} else {
			cj = i
		}
		// find top-edge
		i, j = ri, rj
		for i < j {
			m = (i + j) / 2
			if matrix[m][cj] > target {
				j = m - 1
			} else if matrix[m][cj] < target {
				i = m + 1
			} else {
				return true // fast return
			}
		}
		if matrix[i][cj] >= target {
			ri = i
		} else {
			ri = i + 1
			if ri >= h {
				return false
			}
		}
		// find left-edge
		i, j = ci, cj
		for i < j {
			m = (i + j) / 2
			if matrix[rj][m] > target {
				j = m - 1
			} else if matrix[rj][m] < target {
				i = m + 1
			} else {
				return true // fast return
			}
		}
		if matrix[rj][i] >= target {
			ci = i
		} else {
			ci = i + 1
			if ci >= w {
				return false
			}
		}
	}
	if matrix[ri][ci] == target {
		return true
	}
	return false
}

func main() {
	matrix := [][]int{
		{1, 4, 7, 11, 15},
		{2, 5, 8, 12, 19},
		{3, 6, 9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30},
	}
	// a
	for i := 0; i < 32; i++ {
		fmt.Print("-> i=", i)
		res := searchMatrix(matrix, i)
		fmt.Println(", res=", res)
	}
}
