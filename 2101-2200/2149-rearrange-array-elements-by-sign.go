package main

import (
	"fmt"
)

func rearrangeArray(nums []int) []int {
	nLen := len(nums)
	res := make([]int, nLen)
	oi, ei := 0, 1
	for i := 0; i < nLen; i++ {
		if nums[i] > 0 {
			res[oi] = nums[i]
			oi += 2
		} else {
			res[ei] = nums[i]
			ei += 2
		}
	}

	return res
}

func main() {
	// [3,-2,1,-5,2,-4]
	fmt.Println(rearrangeArray([]int{3, 1, -2, -5, 2, -4}))
}
