package main

import (
	"fmt"
)

// 错位相乘 -- 这个方法也太巧妙了（
// O(n) & O(n)  -- but runtime 60ms, memory 6.3MB
func productExceptSelf_2pass(nums []int) []int {
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

// O(n) & O(1) --- but runtime 60ms, memory 7.2MB
func productExceptSelf(nums []int) []int {
	product := 1
	zeroCount := 0
	for _, num := range nums {
		if num == 0 {
			zeroCount++
		} else {
			product *= num
		}
	}
	if zeroCount > 1 {
		product = 0
	}
	for i, num := range nums {
		if num == 0 {
			if zeroCount > 1 {
				nums[i] = 0
			} else {
				nums[i] = product
			}
		} else {
			if zeroCount > 0 {
				nums[i] = 0
			} else {
				nums[i] = product / num
			}
		}
	}
	return nums
}

func main() {
	// [24,12,8,6]  expected
	fmt.Println(productExceptSelf([]int{1, 2, 3, 4}))
}
