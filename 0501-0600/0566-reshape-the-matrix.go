package main

import "fmt"

func matrixReshape(nums [][]int, r int, c int) [][]int {
	or := len(nums)
	oc := len(nums[0])
	if or*oc != r*c {
		return nums
	}
	result := make([][]int, r)
	ori, oci := 0, 0
	for i := 0; i < r; i++ {
		result[i] = make([]int, c)
		for j := 0; j < c; j++ {
			result[i][j] = nums[ori][oci]
			oci++
			if oci >= oc {
				ori++
				oci = 0
			}
		}
	}

	return result
}

func main() {
	// [[1,2,3,4]]
	fmt.Println(matrixReshape([][]int{{1, 2}, {3, 4}}, 1, 4))
	// [[1,2],[3,4]]
	fmt.Println(matrixReshape([][]int{{1, 2}, {3, 4}}, 2, 4))
}
