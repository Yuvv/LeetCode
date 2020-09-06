package main

import (
	"fmt"
)

func diagonalSum(mat [][]int) int {
	nl := len(mat) - 1
	r := 0
	for i := 0; i <= nl; i++ {
		r += mat[i][i]
		r += mat[i][nl-i]
		if i == nl-i {
			r -= mat[i][i]
		}
	}
	return r
}

func main() {
	fmt.Println(diagonalSum([][]int{
		[]int{1, 2, 3},
		[]int{4, 5, 6},
		[]int{7, 8, 9},
	}))
	fmt.Println(diagonalSum([][]int{
		[]int{1, 2, 3, 4},
		[]int{4, 5, 6, 7},
		[]int{7, 8, 9, 5},
		[]int{7, 8, 9, 5},
	}))
}
