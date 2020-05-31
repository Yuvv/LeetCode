package main

import (
	"fmt"
)

func maxProduct(nums []int) int {
	nLen := len(nums)
	// make `i` max, `j` second max
	i, j := 0, 1
	if nums[i] < nums[j] {
		i = 1
		j = 0
	}
	for k := 2; k < nLen; k++ {
		if nums[k] > nums[i] {
			j = i
			i = k
		} else if nums[k] > nums[j] {
			j = k
		}
	}
	return (nums[i] - 1) * (nums[j] - 1)
}


func main()  {
	// 6 expected
	fmt.Println(maxProduct([]int {3, 4}))
	// 12 expected
	fmt.Println(maxProduct([]int {3, 4, 5, 2}))
	// 16 expected
	fmt.Println(maxProduct([]int {1, 5, 4, 5}))
	// 32 expected
	fmt.Println(maxProduct([]int {1, 3, 4, 5, 2, 9}))
}