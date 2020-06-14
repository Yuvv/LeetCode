package main

import (
	"fmt"
)

func shuffle(nums []int, n int) []int {
	tmpNums := make([]int, n)
	copy(tmpNums, nums)
	for i := 0; i < n; i++ {
		nums[2*i] = tmpNums[i]
		nums[2*i+1] = nums[n+i]
	}
	return nums
}

func main() {
	// [2,3,5,4,1,7] expected
	fmt.Println(shuffle([]int{2, 5, 1, 3, 4, 7}, 3))
	// [1,4,2,3,3,2,4,1] expected
	fmt.Println(shuffle([]int{1, 2, 3, 4, 4, 3, 2, 1}, 4))
	// [1,2,1,2] expected
	fmt.Println(shuffle([]int{1, 1, 2, 2}, 2))
}
