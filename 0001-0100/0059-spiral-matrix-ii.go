package main

import "fmt"

// 生成螺旋数组
// https://leetcode.com/problems/spiral-matrix-ii/
func generateMatrix(n int) [][]int {
	finalTarget := n * n
	// init result matrix
	matrix := make([][]int, n)
	for k := 0; k < n; k++ {
		matrix[k] = make([]int, n)
	}

	top, bottom, left, right := 0, n-1, 0, n-1
	i, j := 0, 0
	count := 1
	for count <= finalTarget {
		for j = left; j <= right; j++ {
			matrix[top][j] = count
			count++
		}
		top++
		if count > finalTarget {
			break
		}

		for i = top; i <= bottom; i++ {
			matrix[i][right] = count
			count++
		}
		right--
		if count > finalTarget {
			break
		}

		for j = right; j >= left; j-- {
			matrix[bottom][j] = count
			count++
		}
		bottom--
		if count > finalTarget {
			break
		}

		for i = bottom; i >= top; i-- {
			matrix[i][left] = count
			count++
		}
		left++
		if count > finalTarget {
			break
		}
	}

	return matrix
}

func main() {
	var result [][]int
	var n, i, j int

	n = 4
	result = generateMatrix(n)
	for i = 0; i < n; i++ {
		for j = 0; j < n; j++ {
			fmt.Print(result[i][j], "  ")
		}
		fmt.Println()
	}
}
