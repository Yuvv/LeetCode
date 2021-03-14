package main

import "fmt"

func spiralMatrixIII(R int, C int, r0 int, c0 int) [][]int {
	totalCellSize := R * C
	matrix := make([][]int, totalCellSize)
	counter := 0
	matrix[counter] = []int{r0, c0}
	boundSize := 2
	r, c := r0, c0
	for counter < totalCellSize-1 {
		// right-down
		c++
		for r < r0+boundSize {
			if c < C && c >= 0 && r >= 0 && r < R {
				counter++
				matrix[counter] = []int{r, c}
			}
			r++
		}
		r--
		// bottom-left
		c--
		for c > c0-boundSize {
			if c < C && c >= 0 && r >= 0 && r < R {
				counter++
				matrix[counter] = []int{r, c}
			}
			c--
		}
		c++
		// left-up
		r--
		for r > r0-boundSize {
			if c < C && c >= 0 && r >= 0 && r < R {
				counter++
				matrix[counter] = []int{r, c}
			}
			r--
		}
		r++
		// top-right
		c++
		for c < c0+boundSize {
			if c < C && c >= 0 && r >= 0 && r < R {
				counter++
				matrix[counter] = []int{r, c}
			}
			c++
		}
		c--

		// finally,
		boundSize++
	}

	return matrix
}

func main() {
	// [[0 0] [0 1] [0 2] [0 3]]
	fmt.Println(spiralMatrixIII(1, 4, 0, 0))
	// [[1 4] [1 5] [2 5] [2 4] [2 3] [1 3] [0 3] [0 4] [0 5] [3 5] [3 4] [3 3] [3 2] [2 2] [1 2] [0 2] [4 5] [4 4] [4 3] [4 2] [4 1] [3 1] [2 1] [1 1] [0 1] [4 0] [3 0] [2 0] [1 0] [0 0]]
	fmt.Println(spiralMatrixIII(5, 6, 1, 4))
}
