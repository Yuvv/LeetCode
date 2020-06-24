package main

import (
	"fmt"
)

// 错位相乘
func productExceptSelf(nums []int) []int {
	nLen := len(nums)
	result := make([]int, nLen)
	product := 1
	result[0] = product
	for i := 1; i < nLen; i++ {
		product *= nums[i-1]
		result[i] = product
	}
	product = 1
	for i := nLen - 2; i >= 0; i-- {
		product *= nums[i+1]
		result[i] *= product
	}
	return result
}

func main() {
	// [24,12,8,6]  expected
	fmt.Println(productExceptSelf([]int{1, 2, 3, 4}))
}
